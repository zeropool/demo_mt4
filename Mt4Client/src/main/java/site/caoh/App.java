package site.caoh;

import java.text.ParseException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) throws ParseException, InterruptedException {
//        Mt4Dll.ping();
//        System.out.println(Mt4Dll.mt4NewGroup("caohuan"));
//        System.out.println(Mt4Dll.mt4NewAdmin(66921494, "caohuan"));

        Mt4Exe.timeout = 10;
        Mt4Exe.port = 9090;
//        Mt4Exe.host = "47.74.130.119";
        Mt4Exe.host = "127.0.0.1";

        int login = 600001;

        Mt4Exe.ping();

//        {
//            List<Map<String, String>> rest = Mt4Exe.mt4AccOrders(login);
//            for (Map<String, String> it : rest) {
//                String str = it.get("open_time");
//                String javatime = Mt4Exe.cvMt4Time2JavaTime(Long.parseLong(str));
//                System.out.println(it.get("order") + " => " + str + " => " + javatime + " => " + Mt4Exe.cvJavaTime2Mt4Time(javatime));
//            }
//        }

        System.out.println(1528433575 > Integer.MAX_VALUE);
        long from = Mt4Exe.cvJavaTime2Mt4Time("2018-06-08 04:52:54");
        long to = Mt4Exe.cvJavaTime2Mt4Time("2018-06-08 04:52:56");
        for (; ; ) {
//            System.out.println(System.currentTimeMillis() + " => " + Mt4Exe.mt4AccOrderHis(login, 1528433575 - 5, 1528433575 + 5));
            System.out.println(System.currentTimeMillis() + " => " + Mt4Exe.mt4AccOrderHis(login, (int) from, (int) to));
        }
    }

    public static void PrintLOGGER() {
        String line = "void ZMt4Service::mt4AccOrderHis(std::vector<std::map<std::string, std::string> > &_return, const int32_t login,\n" +
                "                                 const int32_t tmfrom, const int32_t tmto)";
        String method = "";
        {
            Pattern pattern = Pattern.compile("[::][^(]*[(]");
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                method = matcher.group(0).replace("::", "").replace("(", "");
            }
        }

        List<String> params = new ArrayList<>();
        {
            Pattern pattern = Pattern.compile("\\s+[^\\s,<]+[,)]");
            Matcher matcher = pattern.matcher(line);
            for (; matcher.find(); ) {
                String param = matcher.group();
                param = param.replace(" ", "");
                param = param.replace("&", "");
                param = param.replace("*", "");
                param = param.replace(",", "");
                param = param.replace(")", "");
                params.add(param);
            }
        }

        String sbuffer = "", _return = "";
        for (String param : params) {
            if (!"_return".equals(param)) {
                sbuffer += " << \"" + param + ": \" << " + param + " << \"\\t\"";
            } else {
                _return = param;
            }
        }
        if (_return.length() > 0) {
            sbuffer += "<< \"_return: \" << _return";
        }
        if (params.size() > 0) {
            sbuffer = ", 参数列表 => \"" + sbuffer;
        }
        sbuffer = "LOG(INFO) << \"Thrift Client call " + method + "()" + sbuffer;
        System.out.println(sbuffer + ";");
    }
}