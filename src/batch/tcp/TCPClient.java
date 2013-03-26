/*******************************************************************************
 * The accompanying source code is made available to you under the terms of 
 * the UT Research License (this "UTRL"). By installing or using the code, 
 * you are consenting to be bound by the UTRL. See LICENSE.html for a 
 * full copy of the license.
 * 
 * Copyright 2009, The University of Texas at Austin. All rights reserved.
 * 
 * UNIVERSITY EXPRESSLY DISCLAIMS ANY AND ALL WARRANTIES CONCERNING THIS 
 * SOFTWARE AND DOCUMENTATION, INCLUDING ANY WARRANTIES OF MERCHANTABILITY, 
 * FITNESS FOR ANY PARTICULAR PURPOSE, NON-INFRINGEMENT AND WARRANTIES 
 * OF PERFORMANCE, AND ANY WARRANTY THAT MIGHT OTHERWISE ARISE FROM COURSE 
 * OF DEALING OR USAGE OF TRADE. NO WARRANTY IS EITHER EXPRESS OR IMPLIED 
 * WITH RESPECT TO THE USE OF THE SOFTWARE OR DOCUMENTATION. Under no circumstances 
 * shall University be liable for incidental, special, indirect, direct 
 * or consequential damages or loss of profits, interruption of business, 
 * or related expenses which may arise from use of Software or Documentation, 
 * including but not limited to those resulting from defects in Software 
 * and/or Documentation, or loss or inaccuracy of data of any kind.
 * 
 * Created by: William R. Cook and Eli Tilevich
 * with: Jose Falcon, Marc Fisher II, Ali Ibrahim, Yang Jiao, Ben Wiedermann
 * University of Texas at Austin and Virginia Tech
 ******************************************************************************/
package batch.tcp;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Iterator;

import batch.Service;
import batch.syntax.Format;
import batch.util.BatchTransport;
import batch.util.ForestReader;
import batch.util.ForestWriter;

public class TCPClient<I> extends Format implements Service<String, I> {

	BatchTransport transport;
	
	InetAddress address;
	int port;
	
	public TCPClient(InetAddress address,
			int port, BatchTransport transport) {
		this.transport = transport;
		this.address = address;
		this.port = port;
	}

  @Override
  public void executeServer(String exp, ForestReader data, ForestWriter results) {
    execute(exp, data).copyTo(results);
  }


  public ForestReader execute(String exp, ForestReader data) {
		try {
			Socket socket = new Socket(address, port);
			Writer out = new OutputStreamWriter(socket.getOutputStream());
			out.write(exp);
			out.write("\r\n");
			out.write("\r\n");
			data.copyTo(transport.writer(out));
			out.write("\r\n");
			out.flush();
			Reader in = new InputStreamReader(socket.getInputStream());
			return transport.read(in); // async read!!!
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

  @Override
  public Iterator<I> iterator() {
    throw new Error("Service must be comiled using Java");
  }

}
