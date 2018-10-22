package com.lpc.designpattern.abstractfactory.second;
public class AppleFactory implements IFactory {

	@Override
	public IMobileProduct createMobileProduct() {
		return new AppleMobileProduct();
	}

	@Override
	public IWatchProduct createWatchProduct() {
		return new AppleWatchProduct();
	}

}