package com.lpc.designpattern.abstractfactory.second;
public class AppleMobileProduct implements IMobileProduct {

	@Override
	public void showProduct() {
		System.out.println("苹果手机");
	}
}