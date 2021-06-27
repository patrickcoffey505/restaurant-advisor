package com.example.RestaurantAdvisor.domain;

import java.util.Arrays;

public class FormCommand {
    
	String textField;
 
    String textareaField;
 
    String datetimeField;
 
    String colorField;
 
    boolean singleCheckboxField;
 
    String[] multiCheckboxSelectedValues;
 
    String radioButtonSelectedValue;
    String dropdownSelectedValue;

	String numberField;
    
    
    
	public FormCommand(String textField, String textareaField, String datetimeField, String colorField,
			boolean singleCheckboxField, String[] multiCheckboxSelectedValues, String radioButtonSelectedValue,
			String dropdownSelectedValue, String numberField) {
		super();
		this.textField = textField;
		this.textareaField = textareaField;
		this.datetimeField = datetimeField;
		this.colorField = colorField;
		this.singleCheckboxField = singleCheckboxField;
		this.multiCheckboxSelectedValues = multiCheckboxSelectedValues;
		this.radioButtonSelectedValue = radioButtonSelectedValue;
		this.dropdownSelectedValue = dropdownSelectedValue;
		this.numberField = numberField;
	}
	
	
	public FormCommand() {
		// TODO Auto-generated constructor stub
	}


	public String getTextField() {
		return textField;
	}
	public void setTextField(String textField) {
		this.textField = textField;
	}
	public String getTextareaField() {
		return textareaField;
	}
	public void setTextareaField(String textareaField) {
		this.textareaField = textareaField;
	}
	public String getDatetimeField() {
		return datetimeField;
	}
	public void setDatetimeField(String datetimeField) {
		this.datetimeField = datetimeField;
	}
	public String getColorField() {
		return colorField;
	}
	public void setColorField(String colorField) {
		this.colorField = colorField;
	}
	public boolean isSingleCheckboxField() {
		return singleCheckboxField;
	}
	public void setSingleCheckboxField(boolean singleCheckboxField) {
		this.singleCheckboxField = singleCheckboxField;
	}
	public String[] getMultiCheckboxSelectedValues() {
		return multiCheckboxSelectedValues;
	}
	public void setMultiCheckboxSelectedValues(String[] multiCheckboxSelectedValues) {
		this.multiCheckboxSelectedValues = multiCheckboxSelectedValues;
	}
	public String getRadioButtonSelectedValue() {
		return radioButtonSelectedValue;
	}
	public void setRadioButtonSelectedValue(String radioButtonSelectedValue) {
		this.radioButtonSelectedValue = radioButtonSelectedValue;
	}
	public String getDropdownSelectedValue() {
		return dropdownSelectedValue;
	}
	public void setDropdownSelectedValue(String dropdownSelectedValue) {
		this.dropdownSelectedValue = dropdownSelectedValue;
	}

	public String getNumberField() {
		return numberField;
	}
	public void setNumberField(String numberField) {
		this.numberField = numberField;
	}


	@Override
	public String toString() {
		return "FormCommand [textField=" + textField + ", textareaField=" + textareaField + ", datetimeField="
				+ datetimeField + ", colorField=" + colorField + ", singleCheckboxField=" + singleCheckboxField
				+ ", multiCheckboxSelectedValues=" + Arrays.toString(multiCheckboxSelectedValues)
				+ ", radioButtonSelectedValue=" + radioButtonSelectedValue + ", dropdownSelectedValue="
				+ dropdownSelectedValue + "]";
	}
    
    
    
}