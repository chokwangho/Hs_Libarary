package kr.ac.hansung;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterControllerTest {
   private WebDriver driver;
   private String baseUrl;
   private StringBuffer verificationErrors = new StringBuffer();

   @Before
   public void setUp() throws Exception {
      System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe"); // 크롬드라이버
      driver = new ChromeDriver();
      baseUrl = "http://localhost:8080/";
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
   }

   // 희망 도서 신청 테스트
   @Test
   public void testAddBook() throws Exception {
      // 초기화면으로 이동
      driver.get(baseUrl + "/Hansung_Libary/");
      // 책추가 버튼 클릭
      driver.findElement(By.cssSelector("input[type=\"button\"]")).click();
      Thread.sleep(1000);
      // 책코드 입력
      driver.findElement(By.id("book_code")).clear();
      driver.findElement(By.id("book_code")).sendKeys("1392077");
      Thread.sleep(1000);
      // 책분야 입력
      driver.findElement(By.name("book_type")).click();
      driver.findElement(By.id("title")).clear();
      Thread.sleep(1000);
      // 책제목 입력
      driver.findElement(By.id("title")).sendKeys("조광호 자서전");
      driver.findElement(By.id("author")).clear();
      Thread.sleep(1000);
      // 책작가 입력
      driver.findElement(By.id("author")).sendKeys("조광호");
      driver.findElement(By.id("publish")).clear();
      Thread.sleep(1000);
      // 출판년도 입력
      driver.findElement(By.id("publish")).sendKeys("2016");
      Thread.sleep(1000);
      // 제출
      driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
   }

   // 관심도서추가 테스트
   @Test
   public void testAddRecommand() throws Exception {
      // 초기화면으로이동
      driver.get(baseUrl + "/Hansung_Libary/");
      // 신간도서 알림설정 버튼 클릭
      driver.findElement(By.xpath("//input[@value='신간도서 알림설정']")).click();
      Thread.sleep(1000);
      // 사용자이름입력
      driver.findElement(By.id("member_info")).clear();
      driver.findElement(By.id("member_info")).sendKeys("정상인");
      Thread.sleep(1000);
      // 알립받을 책타입 선택
      driver.findElement(By.id("book_type")).click();
      driver.findElement(By.xpath("(//input[@id='book_type'])[3]")).click();
      driver.findElement(By.xpath("(//input[@id='notify_type'])[2]")).click();
      Thread.sleep(1000);
      // 알림받을 종류 선택후 내용입력
      driver.findElement(By.id("email_add")).clear();
      driver.findElement(By.id("email_add")).sendKeys("happy@happy.co.kr");
      Thread.sleep(1000);
      // 제출
      driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();

   }

   @After
   public void tearDown() throws Exception {
      Thread.sleep(2000);
      driver.quit();
      String verificationErrorString = verificationErrors.toString();
      if (!"".equals(verificationErrorString)) {
         Assert.fail(verificationErrorString);
      }
   }

}