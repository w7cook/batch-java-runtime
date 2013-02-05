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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import batch.Service;
import batch.syntax.Parser;
import batch.util.BatchTransport;
import batch.util.ForestReader;
import batch.util.ForestWriter;

public class TCPServer<E, T> implements Runnable {

  Service<E, T> handler;
  ServerSocket socket;
  BatchTransport transport;
  public boolean debug;

  public TCPServer(Service<E, T> handler, ServerSocket socket,
      BatchTransport transport) throws IOException {
    this.handler = handler;
    this.socket = socket;
    this.transport = transport;
  }

  public void run() {
    while (true) {
      try {
        handle(socket.accept());
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  public void handle(Socket connectionSocket) {
    try {
      BufferedReader in = new BufferedReader(new InputStreamReader(
          connectionSocket.getInputStream()));
      //			Expression exp = BatchScriptParser.parse(in);
      String script = in.readLine();
      if (debug)
        System.out.println("Script: " + script);
      in.readLine(); // Blank line before input
      E exp = Parser.parse(script, handler);
      ForestReader data = transport.read(in);
      // System.out.print("Data: ");
      // System.out.println(data.toString());
      ForestWriter response = transport.writer(new OutputStreamWriter(System.out));
      handler.executeServer(exp, data, response);
      // TODO: supercompilation can combine the execute and write
      // phases!
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void start() {
    System.out.println("Server starting on " + socket);
    Thread thread = new Thread(this);
    thread.start();
  }
}
