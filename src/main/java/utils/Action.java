package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;

public class Action {
	public AppiumDriver driver;
	public TouchAction au;
	
	public Action(AppiumDriver driver){
		this.driver=driver;
		au = new TouchAction(driver);
	}
	
	public void cllick(By by){
		driver.findElement(by).click();
	}
	
	
	/**
	 * 
	 * @param endElement
	 * @param toWhere 滑动方向
	 */
	public void mySwipe(By endElement,String toWhere){
		  WebElement end ;
		  //获取手机的分辨率，即宽和长
		  int width = driver.manage().window().getSize().width;
	      int height = driver.manage().window().getSize().height;
	      //使用死循环，一直找目标元素endelement
		while(true){
			try{
				end = driver.findElement(endElement);
				break;
			}catch(Exception e){
				if(toWhere.equals("上滑")){
					driver.swipe(width / 2, height * 3 / 4, width / 2, height / 4, 3000);
				}else if(toWhere.equals("下滑")){
					driver.swipe(width / 2, height  / 4, width / 2, height * 3/ 4, 3000);
				}else if(toWhere.equals("左滑")){
					driver.swipe(width *3/ 4, height  / 2, width / 4, height / 2, 3000);
				}else{
					driver.swipe(width / 4, height  / 2, width *3/ 4, height / 2, 3000);
				}
			}
		}
		
	}
	
	
}
