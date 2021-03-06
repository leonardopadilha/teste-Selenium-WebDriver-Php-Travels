package testSiteDeCompras;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class testPhpTravelsDsl {

    private WebDriver navegador;

    public testPhpTravelsDsl(WebDriver navegador) {
        this.navegador = navegador;
    }

    public void fecharCook(){
        navegador.findElement(By.xpath("//*[@*='dismiss cookie message']")).click();
    }

    public void realizarScrool(){
        JavascriptExecutor js = (JavascriptExecutor) navegador;
        js.executeScript("javascript:window.scrollBy(250,250)");
    }

    public void escolherHotel(){
        WebElement escolherHotel = navegador.findElement(By.id("s2id_autogen16"));
        escolherHotel.click();
        navegador.findElements(By.xpath("//*[@*='select2-results']//*[@*='select2-result-sub']//*[@*='select2-result-label']")).get(2).click();
    }

    public void informarDataCheckIn(String dataCheckIn){
        WebElement selecionarCheckIn = navegador.findElement(By.id("checkin"));
        selecionarCheckIn.clear();
        selecionarCheckIn.click();
        selecionarCheckIn.sendKeys(dataCheckIn);
    }

    public void informarDataCheckOut(String dataCheckOut){
        WebElement selecionarCheckOut = navegador.findElement(By.id("checkout"));
        selecionarCheckOut.clear();
        selecionarCheckOut.click();
        selecionarCheckOut.sendKeys(dataCheckOut);
    }

    public void clicarBotaoConfirmar(){
        navegador.findElements(By.xpath("//*[@*='submit']")).get(0).click();
    }

    public void conferirPrecoData(){
        navegador.findElement(By.xpath("//*[@*='anchor btn btn-primary btn-wide mt-5']")).click();
    }

    public void selecionarCheckBoxQuarto(){
        navegador.findElement(By.cssSelector(".custom-control.custom-checkbox:nth-child(1):nth-child(1)")).click();
    }

    public void clicarBotaoBookNow(){
        navegador.findElement(By.xpath("//*[@*='submit' and @*='book_button btn btn-success btn-block btn-lg chk']")).click();
    }

    public void primeiroNomeEUltimoNome(){
        navegador.findElement(By.name("firstname")).sendKeys("Primeiro Nome");
        navegador.findElement(By.name("lastname")).sendKeys("Segundo Nome");
    }

    public void informarCadastroEmail(){
        navegador.findElement(By.name("email")).sendKeys("teste@teste.com");
    }

    public void informarEmail(){
        navegador.findElement(By.cssSelector("input[type='email']")).sendKeys("teste@teste.com");
    }

    public void confirmarEmail(){
        navegador.findElement(By.name("confirmemail")).sendKeys("teste@teste.com");
    }

    public void informarTelefone(){
        navegador.findElement(By.name("phone")).sendKeys("(11)99999-9999");
    }

    public void informarEndereco(){
        WebElement endereco = navegador.findElement(By.name("address"));
        endereco.clear();
        endereco.sendKeys("Rua Teste");
    }

    public void informarPais(){
        navegador.findElement(By.xpath("//*[@*='chosen-single']")).click();
        navegador.findElements(By.xpath("//*[@*='active-result']")).get(5).click();
    }

    public void clicarConfirmarCompra(){
        navegador.findElement(By.xpath("//*[@*='submit' and @*='guest']")).click();

        try { Thread.sleep (10000); } catch (InterruptedException ex) {}try { Thread.sleep (10000); } catch (InterruptedException ex) {}
        WebElement mensagem = navegador.findElement(By.xpath("//*[@*='heading-title']"));
        String mensagemCompra = mensagem.getText();
        Assert.assertEquals("Summary", mensagemCompra);
    }

    public void informarPassword(){
        navegador.findElement(By.cssSelector("input[type='password']")).sendKeys("123456");
    }

    public void  confirmarPassword(){
        navegador.findElement(By.cssSelector("input[name='confirmpassword']")).sendKeys("123456");
    }

    public void confirmarCadastro(){
        navegador.findElement(By.cssSelector("button[type='submit']")).click();

        try { Thread.sleep (10000); } catch (InterruptedException ex) {}try { Thread.sleep (10000); } catch (InterruptedException ex) {}
        WebElement msgCadastro = navegador.findElement(By.cssSelector("h3[class='text-align-left']"));
        String msgSucesso = msgCadastro.getText();
        Assert.assertEquals("Hi, Primeiro Nome Segundo Nome", msgSucesso);
    }

    public void realizarLogin(){
        navegador.findElement(By.cssSelector("button[class='btn btn-primary btn-lg btn-block loginbtn']")).click();
    }

    public void clicarPhpTravel(){
        navegador.findElement(By.cssSelector("img[alt='My Account']")).click();
    }

    public void comprarHotelLogado(){
        realizarScrool();
        escolherHotel();
        informarDataCheckIn("20/06/2020");
        informarDataCheckOut("26/06/2020");
        clicarBotaoConfirmar();
        conferirPrecoData();
        selecionarCheckBoxQuarto();
        realizarScrool();
        fecharCook();
        clicarBotaoBookNow();

        realizarScrool();
        fecharCook();
    }

    public void confirmarCompraLogado(){
        navegador.findElement(By.name("logged")).click();
    }
}

