package com.lpc.designpattern.abstractfactory.second;

public class HuaWeiFactory implements IFactory {

	@Override
	public IMobileProduct createMobileProduct() {
		return new HuaWeiMobileProduct();
	}

	@Override
	public IWatchProduct createWatchProduct() {
		return new HuaWeiWatchProduct();
	}

}


