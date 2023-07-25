package com.example.sdetfasttrackselenium.cydeo.pages;

import com.example.sdetfasttrackselenium.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileUploadPage {
    @FindBy(id = "file-upload")
    public WebElement chooseFileButton;

    @FindBy(id = "file-submit")
    public WebElement fileUploadSubmitButton;

    @FindBy(id = "drag-drop-upload")
    public WebElement divDragDropUpload;

    @FindBy(id = "uploaded-files")
    public WebElement upLoadedFiles;

    @FindBy(css = "h3")
    public WebElement headerFileUploaded;

    
    public FileUploadPage(){
        PageFactory.initElements(Driver.get(),this);
    }
}
