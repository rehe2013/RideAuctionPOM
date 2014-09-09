package com.sqa.ra.unit.adapter;

import java.util.Date;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sqa.ra.adapters.RACouponAdapter;
import com.sqa.ra.domain.RACoupon;

import static org.testng.Assert.*;

public class TestRACouponAdapter {
  RACouponAdapter couponAdapter = null;
  
  @BeforeClass
  public void runBeforeClass(){
	  couponAdapter = new RACouponAdapter ();
  }
  
  @Test
  public void testIsCouponValidFalse() {
	  
	  String couponCode = "12345";
	  boolean result = couponAdapter.isCouponValid(couponCode);
	  assertFalse (result);
  }
  
  @Test
  public void testIsCouponValidTrue() {
	  
	  String couponCode = "test17";
	  boolean result = couponAdapter.isCouponValid(couponCode);
	  assertTrue(result);
  }
  
  @Test
  public void testGetCoupon (){
	  String couponCode = "twitter5";
	  RACoupon coupon = null;
	  
	  coupon =couponAdapter.getCoupon(couponCode);
	  //System.out.println ("CouponCode = " + coupon.getCouponCode() + "\t CounponSymbole =" + coupon.getCouponSymbol());
	  assertNotNull(coupon);
	  assertEquals(coupon.getCouponId(),75);
	  assertEquals(coupon.getCouponCode(), "twitter5");
	  assertEquals(coupon.getCouponDiscount(), "5");
	  assertEquals(coupon.getCouponStart(), new Date(1349976480));
	  assertEquals(coupon.getCouponEnd(), new Date(1356912000));
	  System.out.println ("~~~ start " + coupon.getCouponStart().toString() + "\t ~~~~ End " + coupon.getCouponEnd().toString());
	  
	  assertEquals(coupon.getCouponStatus(),1);
	  assertEquals(coupon.getCouponSymbol(), "$");
	  assertEquals(coupon.getCouponQty(), 100);  
  }

  
}
