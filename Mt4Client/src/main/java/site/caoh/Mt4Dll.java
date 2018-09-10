package site.caoh;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import site.caoh.dll.Mt4Service;

public class Mt4Dll {
    public static int port = 9090;
    public static String host = "127.0.0.1";

    public static void ping() {
        TTransport transport = null;
        try {
            transport = new TSocket(host, port, 300000);
            TProtocol protocol = new TBinaryProtocol(transport);
            Mt4Service.Client mt4Client = new Mt4Service.Client(protocol);
            transport.open();

            mt4Client.ping();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != transport) {
                transport.close();
            }
        }
    }

    public static String mt4NewGroup(String group) {
        String result = "";
        TTransport transport = null;
        try {
            transport = new TSocket(host, port, 300000);
            TProtocol protocol = new TBinaryProtocol(transport);
            Mt4Service.Client mt4Client = new Mt4Service.Client(protocol);
            transport.open();

            result = mt4Client.mt4NewGroup(group);

        } catch (Exception e) {
            result = "failure:" + e.getMessage();
            e.printStackTrace();
        } finally {
            if (null != transport) {
                transport.close();
            }
        }
        return result;
    }

    public static String mt4NewAdmin(int login, String groups) {
        String result = "";
        TTransport transport = null;
        try {
            transport = new TSocket(host, port, 300000);
            TProtocol protocol = new TBinaryProtocol(transport);
            Mt4Service.Client mt4Client = new Mt4Service.Client(protocol);
            transport.open();

            result = mt4Client.mt4NewAdmin(login, groups);

        } catch (Exception e) {
            result = "failure:" + e.getMessage();
            e.printStackTrace();
        } finally {
            if (null != transport) {
                transport.close();
            }
        }
        return result;
    }
}
