
package test.java;

import java.io.File;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import main.java.config.Context;
import main.java.config.Utils;
import main.java.utils.Constants;

public class BaseTest {

	// credenciales TIA
	public static String userSuscriptor = "FVALENZU";
	public static String passSuscriptor = "fvalenzu";

	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentSparkReporter spark;
	public static ExtentTest test;
	public static ExtentTest step;

	@BeforeTest(description = "Se configura el controlador y el navegador")
	public void beforeTestMethod() {
		TimeZone timeZone = TimeZone.getTimeZone("America/Santiago");
		TimeZone.setDefault(timeZone);
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("report" + File.separator + "AutomationReport.html");
		spark.config().setDocumentTitle("Reporte de automatización de pruebas");
		spark.config().setEncoding("UTF-8");
		spark.config().setReportName("Resultado Pruebas Automatizadas");
		extent.attachReporter(spark);
		extent.setSystemInfo("Proyecto", "ALMA");
		extent.setSystemInfo("Automatizador", "QA TestGroup");
		extent.setSystemInfo("Sistema Operativo", System.getProperty("os.name"));
		extent.setSystemInfo("Zona horaria", TimeZone.getDefault().getDisplayName());
	}

	@BeforeMethod(description = "Se configura el reporte de pruebas")
	@Parameters(value = { "browserName"})
	public void beforeMethod(String browserName, Method testMethod, ITestResult result) {

		test = extent.createTest(Utils.convertToPascalCase(testMethod.getName()));
		setUpDriver(browserName);
		driver.manage().window().maximize();
//		if(aplicativo.trim().toLowerCase() == "tia") {
//			driver.get(Constants.url);
//		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		String testName = result.getName();
		String evidencia;

		if (result.getStatus() == ITestResult.SUCCESS) {
			step.log(Status.PASS, MarkupHelper.createLabel("Prueba exitosa: " + testName, ExtentColor.GREEN));
			evidencia = Utils.takeScreenshot(testName, "passed");
			step.pass("Clic para visualizar evidencia",
					MediaEntityBuilder.createScreenCaptureFromBase64String(evidencia).build());
			System.out.println("Prueba exitosa: " + testName);
		} else if (result.getStatus() == ITestResult.SKIP) {
			step.log(Status.SKIP, MarkupHelper.createLabel("Prueba incompleta: " + testName, ExtentColor.AMBER));
			evidencia = Utils.takeScreenshot(testName, "skkiped");
			step.pass("Clic para visualizar evidencia",
					MediaEntityBuilder.createScreenCaptureFromBase64String(evidencia).build());
			System.out.println("Prueba incompleta: " + testName);
		} else if (result.getStatus() == ITestResult.FAILURE) {
			Utils.errorLOG(result);
		}
//		driver.quit();
	}

	@AfterTest
	public void afterTest() {
		extent.setSystemInfo("Navegador", ((RemoteWebDriver) driver).getCapabilities().getBrowserName());
		extent.setSystemInfo("Version", ((RemoteWebDriver) driver).getCapabilities().getBrowserVersion());
		extent.flush();
	}

	@Context(description = "Configura el tipo y las características del controlador")
	public void setUpDriver(String browserName) {

		if (browserName.contains("chrome")) {

			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--headless");// Comentar cuando se quiera visualizar el navegador durante la ejecución

			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1920, 1080));

		} else if (browserName.contains("edge")) {
			driver = new EdgeDriver();
		} else if (browserName.contains("firefox")) {
			driver = new FirefoxDriver();
		}
	}
}
