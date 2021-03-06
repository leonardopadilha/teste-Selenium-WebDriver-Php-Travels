package testSiteDeCompras;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class testPhpTravels {

    private WebDriver navegador;
    private testPhpTravelsDsl travelsDsl;
    private String url = "https://www.phptravels.net/home";

        @Before
        public void setUp(){
            System.setProperty("webdriver.chrome.driver", "/home/drivers/chromedriver");
            navegador = new ChromeDriver();

            navegador.manage().window().maximize();
            navegador.get(url);

            navegador.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            travelsDsl = new testPhpTravelsDsl(navegador);
        }

        @After
        public void fecharNavegador(){
            navegador.quit();
        }

        @Test
        public void pesquisarHotelDoisAdultosSemCriancaSemComentario(){
            travelsDsl.fecharCook();

            travelsDsl.realizarScrool();

            travelsDsl.escolherHotel();

            travelsDsl.informarDataCheckIn("20/06/2020");
            travelsDsl.informarDataCheckOut("26/06/2020");
            travelsDsl.clicarBotaoConfirmar();

            travelsDsl.conferirPrecoData();
            travelsDsl.selecionarCheckBoxQuarto();

            travelsDsl.realizarScrool();
            travelsDsl.clicarBotaoBookNow();

            travelsDsl.primeiroNomeEUltimoNome();
            travelsDsl.informarEmail();
            travelsDsl.confirmarEmail();
            travelsDsl.informarTelefone();
            travelsDsl.informarEndereco();
            travelsDsl.informarPais();
            travelsDsl.clicarConfirmarCompra();
        }

        @Test
        public void realizarCadastroLogin(){
            navegador.findElements(By.cssSelector("#dropdownCurrency")).get(1).click();
            navegador.findElement(By.partialLinkText("Sign Up")).click();

            travelsDsl.primeiroNomeEUltimoNome();
            travelsDsl.informarTelefone();
            travelsDsl.informarCadastroEmail();

            travelsDsl.informarPassword();
            travelsDsl.confirmarPassword();

            travelsDsl.fecharCook();
            travelsDsl.realizarScrool();

            travelsDsl.confirmarCadastro();
        }

        @Test
        public void realizarLogin(){
            navegador.findElements(By.cssSelector("#dropdownCurrency")).get(1).click();
            navegador.findElement(By.partialLinkText("Login")).click();

            travelsDsl.informarEmail();
            travelsDsl.informarPassword();

            travelsDsl.realizarLogin();
        }

        @Test
        public void pesquisarHotelDoisAdultosSemCriancaSemComentarioLogado(){
            realizarLogin();
            travelsDsl.clicarPhpTravel();
            travelsDsl.comprarHotelLogado();
            travelsDsl.confirmarCompraLogado();
        }

        @Test
        public void realizarCompraDeslogadoVooApenasIdaUmAdultoSemCriancaSemComentarios() {
            travelsDsl.fecharCook();
            travelsDsl.realizarScrool();

            navegador.findElement(By.cssSelector("a[data-name='flights']")).click();

            WebElement escolherIataFrom = navegador.findElement(By.id("s2id_location_from"));
            escolherIataFrom.click();

            navegador.findElement(By.cssSelector("div[id='select2-drop'] > div[class='select2-search']  > input:last-of-type")).sendKeys("SAO");
            navegador.findElements(By.cssSelector("li > div[class='select2-result-label']")).get(0).click();

            navegador.findElement(By.cssSelector("div[id='s2id_location_to']  > input")).sendKeys("SSA");
            navegador.findElements(By.cssSelector("li > div[class='select2-result-label']")).get(0).click();

            navegador.findElement(By.id("FlightsDateStart")).click();

            navegador.findElements(By.cssSelector("div >div > div:nth-child(20)")).get(8).click();

            navegador.findElements(By.cssSelector("div > button[type='submit']")).get(1).click();

            navegador.findElements(By.cssSelector("div > button[type='submit']")).get(2).click();

            travelsDsl.primeiroNomeEUltimoNome();
            travelsDsl.informarEmail();
            travelsDsl.confirmarEmail();
            travelsDsl.informarTelefone();
            travelsDsl.informarEndereco();
            travelsDsl.realizarScrool();

            navegador.findElement(By.cssSelector("div[class='chosen-container chosen-container-single'] > a > span")).click();

            navegador.findElement(By.cssSelector("input[class='chosen-search-input']")).sendKeys("Braz");
            navegador.findElement(By.cssSelector("ul[class='chosen-results'] > li")).click();

            navegador.findElement(By.id("passenger_name_0")).sendKeys("Primeiro nome e segundo nome");
            navegador.findElement(By.id("passenger_age_0")).sendKeys("30/10/1950");
            navegador.findElement(By.id("passenger_passport_0")).sendKeys("546544656454");

            navegador.findElement(By.cssSelector("button[class='btn btn-success btn-lg btn-block completebook']")).click();






        }
}
