

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;



public class SampleAndroidAppTest {

    String userName = "mohammadk";
    String accessKey = "gkrzT0iFKjDjehXpMTznxM1lHIZXSYjV3H8Ntk0s2rCUJJO3WU";

    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

    AppiumDriver driver;

    @Test
    public void AndroidApp1() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("w3c", true);
            ltOptions.put("platformName", "android");
            ltOptions.put("deviceName", "Pixel.*");
            ltOptions.put("app", "proverbialAndroid");
            //ltOptions.put("appiumVersion", "2.0.0");
            ltOptions.put("build", "jenkins-sample");
            ltOptions.put("autoGrantPermission", true);
            ltOptions.put("isRealMobile", true);
            ltOptions.put("project", "android");
            ltOptions.put("visual", true);
            ltOptions.put("tunnel", true);
            capabilities.setCapability("lt:options", ltOptions);
            capabilities.setCapability("tags", new String[] {"regression", "android"});

            String hub = "http://" + userName + ":" + accessKey + gridURL;
            driver = new AndroidDriver(new URL(hub), capabilities);

            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);





            MobileElement color = (MobileElement) driver.findElementById("com.lambdatest.proverbial:id/color");
            System.out.println("session_id :: "+driver.getSessionId());
            //Changes color to pink
            color.click();
            Thread.sleep(1000);
            //   driver.executeScript("smartui.takeScreenshot=dashboard-1");
            //driver.executeScript("smartui.takeScreenshot=dashboard-1");
            //Back to orginal color
            color.click();

            driver.context("NATIVE_APP");

            driver.getContext();

            MobileElement text = (MobileElement) driver.findElementById("com.lambdatest.proverbial:id/Text");
            //Changes the text to "Proverbial"
            text.click();

            //toast will be visible
            MobileElement toast = (MobileElement) driver.findElementById("com.lambdatest.proverbial:id/toast");
            toast.click();

            //notification will be visible
            MobileElement notification = (MobileElement) driver.findElementById("com.lambdatest.proverbial:id/notification");
            notification.click();
            Thread.sleep(2000);

            //driver.executeScript("smartui.takeScreenshot=dashboard-1");

            //Opens the geolocation page
//            MobileElement geo = (MobileElement) driver.findElementById("com.lambdatest.proverbial:id/geoLocation");
//            geo.click();
//            Thread.sleep(5000);
//
//            //takes back to home page
//            MobileElement home = (MobileElement) driver.findElementByAccessibilityId("Home");
//            home.click();
//
//            //Takes to speed test page
//            MobileElement speedtest = (MobileElement) driver.findElementById("com.lambdatest.proverbial:id/speedTest");
//            speedtest.click();
            // Thread.sleep(5000);



            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
            try{
                driver.quit();
            }catch(Exception e1){
                e.printStackTrace();
            }
        }


    }
}
