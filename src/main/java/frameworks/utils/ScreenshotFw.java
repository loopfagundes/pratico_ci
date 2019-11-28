package frameworks.utils;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class ScreenshotFw {

	private static final String PATH_SCREENSHOT = System.getProperty("user.dir") + File.separator + "reports"
			+ File.separator + "screenshots";

	public static MediaEntityModelProvider takeViewpointShot(WebDriver driver, String nomeMetodo) {
		try {
			// Converter objeto de WebDriver em TakeScreenshot e Mover arquivo
			// de imagem para o destino
			File srcShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			String path = PATH_SCREENSHOT + File.separator + srcShot.getName();

			FileUtils.copyFile(srcShot, new File(path));
			
			return MediaEntityBuilder.createScreenCaptureFromPath(path).build();
			
		} catch (IOException ex) {
			System.out.println("N�o foi possivel gerar imagem!");
		}
		
		return null;
	}

	public static void takeFullPageShot(WebDriver driver, String nomeMetodo) {
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
				.takeScreenshot(driver);

		String path = "target" + File.separator + "screenshot" + File.separator + nomeMetodo
				+ DateTimeFormatterFw.getTime() + ".jpg";

		try {
			ImageIO.write(screenshot.getImage(), "PNG", new File(path));

		} catch (IOException e) {
			System.out.println("N�o foi posss�vel capturar a tela");
			e.printStackTrace();
		}
	}
	
	/**
     * Captura screenshot da tela do navegador ativo
     * Retorna imagem do formato base64
     *
     * @param driver WebDriver
     * @return string
     */
    public static MediaEntityModelProvider capture(WebDriver driver) {
        try {
        	return MediaEntityBuilder.createScreenCaptureFromBase64String(((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64)).build();
        } catch(Exception ex) {}
        return null;
    }
}
