package frameworks.core.keyword;

import javax.annotation.Nullable;
import java.io.File;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class KeywordExecutor {
    public static final String PLATFORM_WEB = "web";
    public static final String PLATFORM_API = "api";
    public static final String WEB_KEYWORD_PACKAGE = "frameworks.core.webui.builtin";
    public static final String API_KEYWORD_PACKAGE = "frameworks.core.api.builtin";

    public static void executeFromPlatform(String platform, String keyWord, @Nullable Object param){
        try {
            String aPackage = getPackage(platform);
            List<Class<?>> list = getAllClass(aPackage, keyWord);
            List<IKeyword> keywordList = new ArrayList<>();
            for (Class<?> cls : list) {
                keywordList.add((IKeyword) cls.newInstance());
            }
            keywordList.get(0).execute(param, null);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void executeFromPlatform(String platform, String keyWord){
        try {
            String aPackage = getPackage(platform);
            List<Class<?>> list = getAllClass(aPackage, keyWord);
            List<IKeyword> keywordList = new ArrayList<>();
            for (Class<?> cls : list) {
                keywordList.add((IKeyword) cls.newInstance());
            }
            keywordList.get(0).execute(null, null);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void executeFromPlatform(String platform, String keyWord, @Nullable Object param1, @Nullable Object param2){
        try {
            String aPackage = getPackage(platform);
            List<Class<?>> list = getAllClass(aPackage, keyWord);
            List<IKeyword> keywordList = new ArrayList<>();
            for (Class<?> cls : list) {
                keywordList.add((IKeyword) cls.newInstance());
            }
            keywordList.get(0).execute(param1, param2);
        } catch(Exception e){
            System.out.println("execute multi");
            e.printStackTrace();
        }
    }

    private static List<Class<?>> getAllClass(String packageName, String keyword) {
        try {
            ArrayList<Class<?>> classes = new ArrayList<Class<?>>();
            ClassLoader cld = KeywordExecutor.class.getClassLoader();
            Enumeration<URL> urls = cld.getResources(packageName.replace('.', '/'));
            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();
                String path = URLDecoder.decode(url.getFile(), StandardCharsets.UTF_8.name());
                if (path.startsWith("/") && path.contains(":")) {
                    path = path.substring(1);
                }
                File f = new File(path);
                if (!f.isDirectory()) {
                    continue;
                }
                for (String fileName : f.list()) {
                    if(fileName.toLowerCase(Locale.ROOT).contains(keyword.toLowerCase(Locale.ROOT))){
                        classes.add(cld.loadClass((packageName + "." + fileName).replaceAll("\\.class", "")));
                    }
                }
            }
            return classes;
        } catch (Exception ex) {
            return Collections.emptyList();
        }
    }

    private static String getPackage(String platform){
        String keywordPackage;
        switch (platform){
            case PLATFORM_WEB:
                keywordPackage = WEB_KEYWORD_PACKAGE; break;
            case PLATFORM_API:
                keywordPackage = API_KEYWORD_PACKAGE; break;
            default:
                throw new IllegalStateException("Unexpected value: " + platform);
        }
        return keywordPackage;
    }

}
