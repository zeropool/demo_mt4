package site.caoh;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import site.caoh.exe.Mt4Service;
import site.caoh.exe.TradeCMD;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Mt4Exe {
    public static int timeout = 10;
    public static int port = 9090;
    public static String host = "127.0.0.1";

    public static void ping() {
        TTransport transport = null;
        try {
            transport = new TSocket(host, port, timeout * 1000);
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

    public static String mt4AccOpen(int login, String name, String group, String email, String password) {
        String result = "";
        TTransport transport = null;
        try {
            transport = new TSocket(host, port, timeout * 1000);
            TProtocol protocol = new TBinaryProtocol(transport);
            Mt4Service.Client mt4Client = new Mt4Service.Client(protocol);
            transport.open();

            result = mt4Client.mt4AccOpen(login, name, group, email, password);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != transport) {
                transport.close();
            }
        }
        return result;
    }

    public static Map<String, String> mt4AccInfo(int login) {
        Map<String, String> result = new HashMap<>();
        TTransport transport = null;
        try {
            transport = new TSocket(host, port, timeout * 1000);
            TProtocol protocol = new TBinaryProtocol(transport);
            Mt4Service.Client mt4Client = new Mt4Service.Client(protocol);
            transport.open();

            result = mt4Client.mt4AccInfo(login);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != transport) {
                transport.close();
            }
        }
        return result;
    }

    public static String mt4ResetPwd(int login, String password) {
        String result = "";
        TTransport transport = null;
        try {
            transport = new TSocket(host, port, timeout * 1000);
            TProtocol protocol = new TBinaryProtocol(transport);
            Mt4Service.Client mt4Client = new Mt4Service.Client(protocol);
            transport.open();

            result = mt4Client.mt4ResetPwd(login, password);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != transport) {
                transport.close();
            }
        }
        return result;
    }

    public static String mt4AccDeposits(int login, double amount) {
        String result = "";
        TTransport transport = null;
        try {
            transport = new TSocket(host, port, timeout * 1000);
            TProtocol protocol = new TBinaryProtocol(transport);
            Mt4Service.Client mt4Client = new Mt4Service.Client(protocol);
            transport.open();

            result = mt4Client.mt4AccDeposits(login, amount);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != transport) {
                transport.close();
            }
        }
        return result;
    }

    public static List<Map<String, String>> mt4AccOrderHis(int login, int tmfrom, int tmto) {
        List<Map<String, String>> result = new ArrayList<>();
        TTransport transport = null;
        try {
            transport = new TSocket(host, port, timeout * 1000);
            TProtocol protocol = new TBinaryProtocol(transport);
            Mt4Service.Client mt4Client = new Mt4Service.Client(protocol);
            transport.open();

            result = mt4Client.mt4AccOrderHis(login, tmfrom, tmto);
//            if (result.isEmpty()) {
//                for (int i = 0; i < 5; i++) {
//                    result = mt4Client.mt4AccOrderHis(login, tmfrom, tmto);
//                    if (!result.isEmpty()) {
//                        break;
//                    } else {
//                        Thread.sleep(1000);
//                    }
//                }
//            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != transport) {
                transport.close();
            }
        }
        return result;
    }

    public static Map<String, String> mt4AccMargin(int login) {
        Map<String, String> result = new HashMap<>();
        TTransport transport = null;
        try {
            transport = new TSocket(host, port, timeout * 1000);
            TProtocol protocol = new TBinaryProtocol(transport);
            Mt4Service.Client mt4Client = new Mt4Service.Client(protocol);
            transport.open();

            result = mt4Client.mt4AccMargin(login);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != transport) {
                transport.close();
            }
        }
        return result;
    }

    public static List<Map<String, String>> mt4AccOrders(int login) {
        TTransport transport = null;
        List<Map<String, String>> result = new ArrayList<>();
        try {
            transport = new TSocket(host, port, timeout * 1000);
            TProtocol protocol = new TBinaryProtocol(transport);
            Mt4Service.Client mt4Client = new Mt4Service.Client(protocol);
            transport.open();

            result = mt4Client.mt4AccOrders(login);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != transport) {
                transport.close();
            }
        }
        return result;
    }


    public static String mt4AccOrderNew(int login, TradeCMD cmd, String symbol, int volume, double price, double stoploss, double takeprofit, String comment) {
        String result = "";
        TTransport transport = null;
        try {
            transport = new TSocket(host, port, timeout * 1000);
            TProtocol protocol = new TBinaryProtocol(transport);
            Mt4Service.Client mt4Client = new Mt4Service.Client(protocol);
            transport.open();

            result = mt4Client.mt4AccOrderNew(login, cmd, symbol, volume, price, stoploss, takeprofit, comment);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != transport) {
                transport.close();
            }
        }
        return result;
    }

    public static List<Map<String, String>> mt4Market() {
        TTransport transport = null;
        List<Map<String, String>> result = new ArrayList<>();
        try {
            transport = new TSocket(host, port, timeout * 1000);
            TProtocol protocol = new TBinaryProtocol(transport);
            Mt4Service.Client mt4Client = new Mt4Service.Client(protocol);
            transport.open();

            result = mt4Client.mt4Market();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != transport) {
                transport.close();
            }
        }
        return result;
    }

    public static String mt4SetLeverage(int login, int leverage) {
        String result = "";
        TTransport transport = null;
        try {
            transport = new TSocket(host, port, timeout * 1000);
            TProtocol protocol = new TBinaryProtocol(transport);
            Mt4Service.Client mt4Client = new Mt4Service.Client(protocol);
            transport.open();

            result = mt4Client.mt4SetLeverage(login, leverage);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != transport) {
                transport.close();
            }
        }
        return result;
    }

    public static String mt4GetTimezone() {
        String result = "";
        TTransport transport = null;
        try {
            transport = new TSocket(host, port, timeout * 1000);
            TProtocol protocol = new TBinaryProtocol(transport);
            Mt4Service.Client mt4Client = new Mt4Service.Client(protocol);
            transport.open();

            result = mt4Client.mt4GetTimezone();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != transport) {
                transport.close();
            }
        }
        return result;
    }

    public static String cvMt4Time2JavaTime(long t) {
        Date date = new Date(t * 1000);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        return sdf.format(date);
    }

    public static int cvJavaTime2Mt4Time(String s) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        return (int) (sdf.parse(s).getTime() / 1000);
    }
}
