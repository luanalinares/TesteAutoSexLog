package testes;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;
import java.util.Hashtable;
import java.util.Map;

public class AcessoEAssinatura {
    private WebDriver navegador;
    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\luana.linares\\Drivers\\chromedriver.exe");

        Map<String, Object> chromePreferences = new Hashtable<String, Object>();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("prefs", chromePreferences);

        navegador = new ChromeDriver(chromeOptions);

        //Acessando a página do SexLog
        navegador.manage().window().maximize();
        navegador.get("https://www.sexlog.com/");
        navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        navegador.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

    }
    @Test
    public void testAcesoEAssinatura() throws InterruptedException {
        // Espera Dinamica.
        WebDriverWait wait = new WebDriverWait(navegador, 30);

        //Fazendo login
        navegador.findElement(By.name("login")).sendKeys("usertoexam");

        //Informando a senha
        navegador.findElement(By.name("password")).sendKeys("123456");

        //Clicar em Entrar
        navegador.findElement(By.xpath("/html/body/nav/div/div/div[2]/form/button")).click();

        //Clicar no botão "ASSINE"
        navegador.findElement(By.xpath("/html/body/header/nav/div/div[2]/a")).click();

        //Selevionar o plano "3 Meses"
        navegador.findElement(By.xpath("/html/body/div[18]/div/div/div[2]/div/div[1]/div[1]/ul/li[3]/div[1]")).click();
        navegador.findElement(By.className("button")).click();

        //Informações de Pagamento
        navegador.findElement(By.xpath("/html/body/div[18]/div/div/div[2]/div/div[2]/div/div/div[1]/ul/li[3]/a")).click();
        navegador.findElement(By.xpath("/html/body/div[18]/div/div/div[2]/div/div[2]/div/div/div[2]/div/div[4]/div/div/form/div/div/div[1]/div[2]/div/div/input")).sendKeys("096.368.068-45");

        //Gerando Boleto
        navegador.findElement(By.xpath("/html/body/div[18]/div/div/div[2]/div/div[2]/div/div/div[2]/div/div[4]/div/div/form/div/div/div[2]/div[2]/button")).click();
        Thread.sleep(10000);
        navegador.findElement(By.xpath("/html/body/div[18]/div/div/div[2]/div[1]/button[1]")).click();

        //Logout
        navegador.findElement(By.xpath("//*[@id=\"dropdown-toggle\"]/a/img")).click();
        navegador.findElement(By.xpath("/html/body/header/nav/div/ul[2]/ul/li[11]/a")).click();

    }
}
