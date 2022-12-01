import org.junit.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CadastroPages;


public class CadastroTest {

    static WebDriver driver;
    static CadastroPages cadastroPages;

    private String produtoNaoExiste;
    private String cidade;

    @BeforeClass
    public static void setupBeforeClass() throws Exception {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        driver.manage().window().maximize();

        cadastroPages = new CadastroPages(driver);
    }

    @Test
    public void caminhoFeliz() throws InterruptedException {
        driver.get(("https://www.americanas.com.br/"));
        produtoNaoExiste = "asdfhjklç";
        cadastroPages.preencherNome(produtoNaoExiste);
        Thread.sleep(5000);
        Assert.assertEquals(cadastroPages.validarResultado(), "poxa, nenhum resultado encontrado para \"asdfhjklc\".");
    }

    @Test
    public void validarCidadeProxima() throws InterruptedException {
        driver.get("https://nossaslojas.americanas.com.br/?chave=o2o_hm_00_0_0_nossaslojas");
        cidade = "Porto Alegre";
        cadastroPages.procurarPorCidade(cidade);
        Thread.sleep(5000);
        Assert.assertEquals(cadastroPages.validarMensagemCidade() , "20 Americanas perto de você");

        //parte 2
        cidade = "Martello";
        cadastroPages.trocarEndereco(cidade);
        Thread.sleep(5000);
        Assert.assertEquals(cadastroPages.validarMensagemCidade() , "1 Americanas perto de você");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        Thread.sleep(3000);
        driver.close();
    }
}
