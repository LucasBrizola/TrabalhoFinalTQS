package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CadastroPages {
    static WebDriver driver;

    public CadastroPages(WebDriver driver) {
        this.driver = driver;
    }

    public void preencherNome(String produtoNaoExiste){
        WebElement nome = driver.findElement(By.name("conteudo"));
        nome.sendKeys(produtoNaoExiste);
        nome.sendKeys(Keys.ENTER);
    }

    public String validarResultado() {
        return driver.findElement(By.xpath("//*[@id=\"rsyswpsdk\"]/div/main/div/div[1]/section[1]/span[1]")).getText();
    }

    public void procurarPorCidade(String cidade) {
        WebElement buscaCidade = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div/div/div[1]/input"));
        buscaCidade.sendKeys(cidade);
        buscaCidade.sendKeys(Keys.ENTER);
    }

    public void trocarEndereco(String cidade) {
        WebElement botaoTrocaEndereco = driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/div/div[2]/span"));
        botaoTrocaEndereco.click();
        WebElement campoTrocaEndereco = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div[1]/input"));
        campoTrocaEndereco.sendKeys(cidade);
        campoTrocaEndereco.sendKeys(Keys.DOWN, Keys.RETURN);
    }

    public WebDriverWait espera5segundos() {
        return new WebDriverWait(driver, 5);
    }

    public String validarMensagemCidade() {
        return driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div[2]/div/div[1]/span")).getText();
    }
}
