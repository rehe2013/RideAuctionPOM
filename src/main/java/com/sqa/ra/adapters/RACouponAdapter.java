package com.sqa.ra.adapters;

import java.sql.ResultSet;
import java.util.Date;

import org.apache.log4j.Logger;

import com.sqa.ra.db.adapters.RADatabaseAdapter;
import com.sqa.ra.domain.RACoupon;



public class RACouponAdapter {
	static Logger logger=Logger.getLogger(RACouponAdapter.class);
	/**
	 * 
	 * @param couponCode
	 * @return
	 */
	public boolean isCouponValid(String couponCode){
		logger.info("start of coupon method");
		String Query="select count(*) from  tblcoupons where trim(CouponCode)='"+
		couponCode+"' AND CouponCount > 0";
		ResultSet rs=RADatabaseAdapter.executeQuery(Query);
		try{
			
			if(rs.next()&&rs.getInt(1)>0){
				return true;
			}	
		}catch(Exception ex){
			ex.printStackTrace();
			logger.error(ex);
		}

		return false;
		
		
	}
	/**
	 * 
	 * @param couponCode
	 * @throws Exception
	 */
	
	public void applyCoupon(String couponCode) throws Exception{
		if(!isCouponValid(couponCode)){
			throw new Exception("Coupon is not valid anymore");
		}
		
		String query="update tblcoupons set CouponCount=CouponCount-1 where CouponCode='"+
		couponCode+"'";
		
		RADatabaseAdapter.executeUpdate(query);
	}
	/**
	 * 
	 */
	/**
	 * 
	 * Returns the coupon details of the coupon
	 */
	/**
	 * 
	 * @param couponCode
	 * @return RACoupon object
	 */
	public RACoupon getCoupon(String couponCode){
		
		logger.info("start of coupon method");
		String Query="select * from  tblcoupons where CouponCode='"+
		couponCode+"' AND CouponCount > 0";
		ResultSet rs=RADatabaseAdapter.executeQuery(Query);
		RACoupon coupon=new RACoupon();
		try{
			while( rs.next()){
				coupon.setCouponId(rs.getLong(1));
				coupon.setCouponCode(rs.getString(2));
				coupon.setCouponDiscount(rs.getString(3));
				coupon.setCouponStart(new Date(rs.getLong(4)));
				coupon.setCouponEnd(new Date(rs.getLong(5)));
				coupon.setCouponStatus(rs.getInt(6));
				//coupon.setCouponSymbol(rs.getString(7));
				coupon.setCouponQty(rs.getInt(8));
				break;
			}
			
			return coupon;

		}catch(Exception ex){
			logger.error(ex);
		}
		logger.debug("end of coupon method");
		return null;
		
	}
	/**
	 * 
	 * @param couponCode
	 * @param qty
	 */
	public  void addMoreCoupon(String couponCode,int qty){
		
		logger.info("start of coupon method");
		String Query="select count(*) from  tblcoupons where CouponCode='"+
		couponCode+"'";
		ResultSet rs=RADatabaseAdapter.executeQuery(Query);
		try{
			if(rs.getInt(1)<1){
				throw new Exception("Not a valid coupon code");
			}	
			
			String query="update tblcoupons set CouponCount=CouponCount+qty where CouponCode='"+
					couponCode+"'";
			RADatabaseAdapter.executeUpdate(query);
		}catch(Exception ex){
			logger.error(ex);
		}
		
		
	}
	
	public static void main(String[] args) throws Exception {
		RACouponAdapter raad= new RACouponAdapter();
		//raad.isCouponValid("12345");
		raad.applyCoupon("twitter5");
		
		raad.getCoupon("twitter5");
	}
	

}
