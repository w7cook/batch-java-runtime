package tcp;

import java.io.IOException;
import java.net.ServerSocket;

import batch.EvalService;
import batch.json.JSONTransport;
import batch.syntax.Evaluate;
import batch.tcp.TCPServer;
import batch.util.BatchTransport;
import batch.xml.XMLTransport;
import eval.BasicInterface;
import eval.BasicObj;

public class TestServer {

	/**
	 * @param args
	 */
	public static void main(String[] argv) {
		String format = argv[0];
		int port = Integer.parseInt(argv[1]);

		try {
			if (format.equals("JSON"))
				runServer(port, new JSONTransport());
			else if (format.equals("XML"))
				runServer(port, new XMLTransport());
			else
				System.out.println("Unknown format: " + format);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void runServer(int port, BatchTransport transport)
			throws IOException {
		BasicObj root = new BasicObj(1000);
		EvalService<BasicInterface> handler = new EvalService<BasicInterface>(root);
		TCPServer<Evaluate, BasicInterface> server = new TCPServer<Evaluate, BasicInterface>(
				handler, new ServerSocket(port), transport, new batch.syntax.Eval());
		server.debug = true;
		server.start();
	}

}
