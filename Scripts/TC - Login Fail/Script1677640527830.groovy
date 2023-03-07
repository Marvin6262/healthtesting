import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

if (Condition == 'Pass') {
    WebUI.callTestCase(findTestCase('TC - Login Input'), [('Username') : UsernamePass, ('Password') : PasswordPass], FailureHandling.STOP_ON_FAILURE)

    WebUI.selectOptionByValue(findTestObject('Page_CURA Healthcare Service/select_Tokyo CURA Healthcare Center                            Hongkong CURA Healthcare Center                            Seoul CURA Healthcare Center'), 
        Healthcare, true)

    if (Checklist == 'yes') {
        WebUI.check(findTestObject('Page_CURA Healthcare Service/input_Apply for hospital readmission_hospital_readmission'))
    } else if (Checklist == 'no') {
        WebUI.uncheck(findTestObject('Page_CURA Healthcare Service/input_Apply for hospital readmission_hospital_readmission'))
    }
    
    if (Program == 'Medicaid') {
        WebUI.click(findTestObject('Page_CURA Healthcare Service/input_Medicaid_programs'))
    } else if (Program == 'Medicare') {
        WebUI.click(findTestObject('Page_CURA Healthcare Service/input_Medicare_programs'))
    } else if (Program == 'None') {
        WebUI.click(findTestObject('Page_CURA Healthcare Service/input_None_programs'))
    }
    
    WebUI.setText(findTestObject('Page_CURA Healthcare Service/input_Visit Date (Required)_visit_date'), VisitDate)

    WebUI.setText(findTestObject('Page_CURA Healthcare Service/textarea_Comment_comment'), Comment)

    WebUI.click(findTestObject('Page_CURA Healthcare Service/button_Book Appointment'))

    WebUI.takeFullPageScreenshot()
} else if (Condition == 'Fail') {
    WebUI.callTestCase(findTestCase('TC - Login Input'), [('Username') : UsernameFail, ('Password') : PasswordFail], FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('Page_CURA Healthcare Service/p_Login failed Please ensure the username and password are valid'), 
        20)

    WebUI.takeFullPageScreenshot()
}

