package com.yiya.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TabOnhandVehicleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TabOnhandVehicleExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andOnhand_vehicle_idIsNull() {
            addCriterion("onhand_vehicle_id is null");
            return (Criteria) this;
        }

        public Criteria andOnhand_vehicle_idIsNotNull() {
            addCriterion("onhand_vehicle_id is not null");
            return (Criteria) this;
        }

        public Criteria andOnhand_vehicle_idEqualTo(Long value) {
            addCriterion("onhand_vehicle_id =", value, "onhand_vehicle_id");
            return (Criteria) this;
        }

        public Criteria andOnhand_vehicle_idNotEqualTo(Long value) {
            addCriterion("onhand_vehicle_id <>", value, "onhand_vehicle_id");
            return (Criteria) this;
        }

        public Criteria andOnhand_vehicle_idGreaterThan(Long value) {
            addCriterion("onhand_vehicle_id >", value, "onhand_vehicle_id");
            return (Criteria) this;
        }

        public Criteria andOnhand_vehicle_idGreaterThanOrEqualTo(Long value) {
            addCriterion("onhand_vehicle_id >=", value, "onhand_vehicle_id");
            return (Criteria) this;
        }

        public Criteria andOnhand_vehicle_idLessThan(Long value) {
            addCriterion("onhand_vehicle_id <", value, "onhand_vehicle_id");
            return (Criteria) this;
        }

        public Criteria andOnhand_vehicle_idLessThanOrEqualTo(Long value) {
            addCriterion("onhand_vehicle_id <=", value, "onhand_vehicle_id");
            return (Criteria) this;
        }

        public Criteria andOnhand_vehicle_idIn(List<Long> values) {
            addCriterion("onhand_vehicle_id in", values, "onhand_vehicle_id");
            return (Criteria) this;
        }

        public Criteria andOnhand_vehicle_idNotIn(List<Long> values) {
            addCriterion("onhand_vehicle_id not in", values, "onhand_vehicle_id");
            return (Criteria) this;
        }

        public Criteria andOnhand_vehicle_idBetween(Long value1, Long value2) {
            addCriterion("onhand_vehicle_id between", value1, value2, "onhand_vehicle_id");
            return (Criteria) this;
        }

        public Criteria andOnhand_vehicle_idNotBetween(Long value1, Long value2) {
            addCriterion("onhand_vehicle_id not between", value1, value2, "onhand_vehicle_id");
            return (Criteria) this;
        }

        public Criteria andAccess_idIsNull() {
            addCriterion("access_id is null");
            return (Criteria) this;
        }

        public Criteria andAccess_idIsNotNull() {
            addCriterion("access_id is not null");
            return (Criteria) this;
        }

        public Criteria andAccess_idEqualTo(Integer value) {
            addCriterion("access_id =", value, "access_id");
            return (Criteria) this;
        }

        public Criteria andAccess_idNotEqualTo(Integer value) {
            addCriterion("access_id <>", value, "access_id");
            return (Criteria) this;
        }

        public Criteria andAccess_idGreaterThan(Integer value) {
            addCriterion("access_id >", value, "access_id");
            return (Criteria) this;
        }

        public Criteria andAccess_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("access_id >=", value, "access_id");
            return (Criteria) this;
        }

        public Criteria andAccess_idLessThan(Integer value) {
            addCriterion("access_id <", value, "access_id");
            return (Criteria) this;
        }

        public Criteria andAccess_idLessThanOrEqualTo(Integer value) {
            addCriterion("access_id <=", value, "access_id");
            return (Criteria) this;
        }

        public Criteria andAccess_idIn(List<Integer> values) {
            addCriterion("access_id in", values, "access_id");
            return (Criteria) this;
        }

        public Criteria andAccess_idNotIn(List<Integer> values) {
            addCriterion("access_id not in", values, "access_id");
            return (Criteria) this;
        }

        public Criteria andAccess_idBetween(Integer value1, Integer value2) {
            addCriterion("access_id between", value1, value2, "access_id");
            return (Criteria) this;
        }

        public Criteria andAccess_idNotBetween(Integer value1, Integer value2) {
            addCriterion("access_id not between", value1, value2, "access_id");
            return (Criteria) this;
        }

        public Criteria andPre_license_plate_idIsNull() {
            addCriterion("pre_license_plate_id is null");
            return (Criteria) this;
        }

        public Criteria andPre_license_plate_idIsNotNull() {
            addCriterion("pre_license_plate_id is not null");
            return (Criteria) this;
        }

        public Criteria andPre_license_plate_idEqualTo(Integer value) {
            addCriterion("pre_license_plate_id =", value, "pre_license_plate_id");
            return (Criteria) this;
        }

        public Criteria andPre_license_plate_idNotEqualTo(Integer value) {
            addCriterion("pre_license_plate_id <>", value, "pre_license_plate_id");
            return (Criteria) this;
        }

        public Criteria andPre_license_plate_idGreaterThan(Integer value) {
            addCriterion("pre_license_plate_id >", value, "pre_license_plate_id");
            return (Criteria) this;
        }

        public Criteria andPre_license_plate_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("pre_license_plate_id >=", value, "pre_license_plate_id");
            return (Criteria) this;
        }

        public Criteria andPre_license_plate_idLessThan(Integer value) {
            addCriterion("pre_license_plate_id <", value, "pre_license_plate_id");
            return (Criteria) this;
        }

        public Criteria andPre_license_plate_idLessThanOrEqualTo(Integer value) {
            addCriterion("pre_license_plate_id <=", value, "pre_license_plate_id");
            return (Criteria) this;
        }

        public Criteria andPre_license_plate_idIn(List<Integer> values) {
            addCriterion("pre_license_plate_id in", values, "pre_license_plate_id");
            return (Criteria) this;
        }

        public Criteria andPre_license_plate_idNotIn(List<Integer> values) {
            addCriterion("pre_license_plate_id not in", values, "pre_license_plate_id");
            return (Criteria) this;
        }

        public Criteria andPre_license_plate_idBetween(Integer value1, Integer value2) {
            addCriterion("pre_license_plate_id between", value1, value2, "pre_license_plate_id");
            return (Criteria) this;
        }

        public Criteria andPre_license_plate_idNotBetween(Integer value1, Integer value2) {
            addCriterion("pre_license_plate_id not between", value1, value2, "pre_license_plate_id");
            return (Criteria) this;
        }

        public Criteria andLicense_plateIsNull() {
            addCriterion("license_plate is null");
            return (Criteria) this;
        }

        public Criteria andLicense_plateIsNotNull() {
            addCriterion("license_plate is not null");
            return (Criteria) this;
        }

        public Criteria andLicense_plateEqualTo(String value) {
            addCriterion("license_plate =", value, "license_plate");
            return (Criteria) this;
        }

        public Criteria andLicense_plateNotEqualTo(String value) {
            addCriterion("license_plate <>", value, "license_plate");
            return (Criteria) this;
        }

        public Criteria andLicense_plateGreaterThan(String value) {
            addCriterion("license_plate >", value, "license_plate");
            return (Criteria) this;
        }

        public Criteria andLicense_plateGreaterThanOrEqualTo(String value) {
            addCriterion("license_plate >=", value, "license_plate");
            return (Criteria) this;
        }

        public Criteria andLicense_plateLessThan(String value) {
            addCriterion("license_plate <", value, "license_plate");
            return (Criteria) this;
        }

        public Criteria andLicense_plateLessThanOrEqualTo(String value) {
            addCriterion("license_plate <=", value, "license_plate");
            return (Criteria) this;
        }

        public Criteria andLicense_plateLike(String value) {
            addCriterion("license_plate like", value, "license_plate");
            return (Criteria) this;
        }

        public Criteria andLicense_plateNotLike(String value) {
            addCriterion("license_plate not like", value, "license_plate");
            return (Criteria) this;
        }

        public Criteria andLicense_plateIn(List<String> values) {
            addCriterion("license_plate in", values, "license_plate");
            return (Criteria) this;
        }

        public Criteria andLicense_plateNotIn(List<String> values) {
            addCriterion("license_plate not in", values, "license_plate");
            return (Criteria) this;
        }

        public Criteria andLicense_plateBetween(String value1, String value2) {
            addCriterion("license_plate between", value1, value2, "license_plate");
            return (Criteria) this;
        }

        public Criteria andLicense_plateNotBetween(String value1, String value2) {
            addCriterion("license_plate not between", value1, value2, "license_plate");
            return (Criteria) this;
        }

        public Criteria andEntry_timeIsNull() {
            addCriterion("entry_time is null");
            return (Criteria) this;
        }

        public Criteria andEntry_timeIsNotNull() {
            addCriterion("entry_time is not null");
            return (Criteria) this;
        }

        public Criteria andEntry_timeEqualTo(Date value) {
            addCriterion("entry_time =", value, "entry_time");
            return (Criteria) this;
        }

        public Criteria andEntry_timeNotEqualTo(Date value) {
            addCriterion("entry_time <>", value, "entry_time");
            return (Criteria) this;
        }

        public Criteria andEntry_timeGreaterThan(Date value) {
            addCriterion("entry_time >", value, "entry_time");
            return (Criteria) this;
        }

        public Criteria andEntry_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("entry_time >=", value, "entry_time");
            return (Criteria) this;
        }

        public Criteria andEntry_timeLessThan(Date value) {
            addCriterion("entry_time <", value, "entry_time");
            return (Criteria) this;
        }

        public Criteria andEntry_timeLessThanOrEqualTo(Date value) {
            addCriterion("entry_time <=", value, "entry_time");
            return (Criteria) this;
        }

        public Criteria andEntry_timeIn(List<Date> values) {
            addCriterion("entry_time in", values, "entry_time");
            return (Criteria) this;
        }

        public Criteria andEntry_timeNotIn(List<Date> values) {
            addCriterion("entry_time not in", values, "entry_time");
            return (Criteria) this;
        }

        public Criteria andEntry_timeBetween(Date value1, Date value2) {
            addCriterion("entry_time between", value1, value2, "entry_time");
            return (Criteria) this;
        }

        public Criteria andEntry_timeNotBetween(Date value1, Date value2) {
            addCriterion("entry_time not between", value1, value2, "entry_time");
            return (Criteria) this;
        }

        public Criteria andPark_typeIsNull() {
            addCriterion("park_type is null");
            return (Criteria) this;
        }

        public Criteria andPark_typeIsNotNull() {
            addCriterion("park_type is not null");
            return (Criteria) this;
        }

        public Criteria andPark_typeEqualTo(Short value) {
            addCriterion("park_type =", value, "park_type");
            return (Criteria) this;
        }

        public Criteria andPark_typeNotEqualTo(Short value) {
            addCriterion("park_type <>", value, "park_type");
            return (Criteria) this;
        }

        public Criteria andPark_typeGreaterThan(Short value) {
            addCriterion("park_type >", value, "park_type");
            return (Criteria) this;
        }

        public Criteria andPark_typeGreaterThanOrEqualTo(Short value) {
            addCriterion("park_type >=", value, "park_type");
            return (Criteria) this;
        }

        public Criteria andPark_typeLessThan(Short value) {
            addCriterion("park_type <", value, "park_type");
            return (Criteria) this;
        }

        public Criteria andPark_typeLessThanOrEqualTo(Short value) {
            addCriterion("park_type <=", value, "park_type");
            return (Criteria) this;
        }

        public Criteria andPark_typeIn(List<Short> values) {
            addCriterion("park_type in", values, "park_type");
            return (Criteria) this;
        }

        public Criteria andPark_typeNotIn(List<Short> values) {
            addCriterion("park_type not in", values, "park_type");
            return (Criteria) this;
        }

        public Criteria andPark_typeBetween(Short value1, Short value2) {
            addCriterion("park_type between", value1, value2, "park_type");
            return (Criteria) this;
        }

        public Criteria andPark_typeNotBetween(Short value1, Short value2) {
            addCriterion("park_type not between", value1, value2, "park_type");
            return (Criteria) this;
        }

        public Criteria andVehicle_type_idIsNull() {
            addCriterion("vehicle_type_id is null");
            return (Criteria) this;
        }

        public Criteria andVehicle_type_idIsNotNull() {
            addCriterion("vehicle_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andVehicle_type_idEqualTo(Integer value) {
            addCriterion("vehicle_type_id =", value, "vehicle_type_id");
            return (Criteria) this;
        }

        public Criteria andVehicle_type_idNotEqualTo(Integer value) {
            addCriterion("vehicle_type_id <>", value, "vehicle_type_id");
            return (Criteria) this;
        }

        public Criteria andVehicle_type_idGreaterThan(Integer value) {
            addCriterion("vehicle_type_id >", value, "vehicle_type_id");
            return (Criteria) this;
        }

        public Criteria andVehicle_type_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("vehicle_type_id >=", value, "vehicle_type_id");
            return (Criteria) this;
        }

        public Criteria andVehicle_type_idLessThan(Integer value) {
            addCriterion("vehicle_type_id <", value, "vehicle_type_id");
            return (Criteria) this;
        }

        public Criteria andVehicle_type_idLessThanOrEqualTo(Integer value) {
            addCriterion("vehicle_type_id <=", value, "vehicle_type_id");
            return (Criteria) this;
        }

        public Criteria andVehicle_type_idIn(List<Integer> values) {
            addCriterion("vehicle_type_id in", values, "vehicle_type_id");
            return (Criteria) this;
        }

        public Criteria andVehicle_type_idNotIn(List<Integer> values) {
            addCriterion("vehicle_type_id not in", values, "vehicle_type_id");
            return (Criteria) this;
        }

        public Criteria andVehicle_type_idBetween(Integer value1, Integer value2) {
            addCriterion("vehicle_type_id between", value1, value2, "vehicle_type_id");
            return (Criteria) this;
        }

        public Criteria andVehicle_type_idNotBetween(Integer value1, Integer value2) {
            addCriterion("vehicle_type_id not between", value1, value2, "vehicle_type_id");
            return (Criteria) this;
        }

        public Criteria andSentry_user_idIsNull() {
            addCriterion("sentry_user_id is null");
            return (Criteria) this;
        }

        public Criteria andSentry_user_idIsNotNull() {
            addCriterion("sentry_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andSentry_user_idEqualTo(Integer value) {
            addCriterion("sentry_user_id =", value, "sentry_user_id");
            return (Criteria) this;
        }

        public Criteria andSentry_user_idNotEqualTo(Integer value) {
            addCriterion("sentry_user_id <>", value, "sentry_user_id");
            return (Criteria) this;
        }

        public Criteria andSentry_user_idGreaterThan(Integer value) {
            addCriterion("sentry_user_id >", value, "sentry_user_id");
            return (Criteria) this;
        }

        public Criteria andSentry_user_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("sentry_user_id >=", value, "sentry_user_id");
            return (Criteria) this;
        }

        public Criteria andSentry_user_idLessThan(Integer value) {
            addCriterion("sentry_user_id <", value, "sentry_user_id");
            return (Criteria) this;
        }

        public Criteria andSentry_user_idLessThanOrEqualTo(Integer value) {
            addCriterion("sentry_user_id <=", value, "sentry_user_id");
            return (Criteria) this;
        }

        public Criteria andSentry_user_idIn(List<Integer> values) {
            addCriterion("sentry_user_id in", values, "sentry_user_id");
            return (Criteria) this;
        }

        public Criteria andSentry_user_idNotIn(List<Integer> values) {
            addCriterion("sentry_user_id not in", values, "sentry_user_id");
            return (Criteria) this;
        }

        public Criteria andSentry_user_idBetween(Integer value1, Integer value2) {
            addCriterion("sentry_user_id between", value1, value2, "sentry_user_id");
            return (Criteria) this;
        }

        public Criteria andSentry_user_idNotBetween(Integer value1, Integer value2) {
            addCriterion("sentry_user_id not between", value1, value2, "sentry_user_id");
            return (Criteria) this;
        }

        public Criteria andEntry_pic_idIsNull() {
            addCriterion("entry_pic_id is null");
            return (Criteria) this;
        }

        public Criteria andEntry_pic_idIsNotNull() {
            addCriterion("entry_pic_id is not null");
            return (Criteria) this;
        }

        public Criteria andEntry_pic_idEqualTo(Long value) {
            addCriterion("entry_pic_id =", value, "entry_pic_id");
            return (Criteria) this;
        }

        public Criteria andEntry_pic_idNotEqualTo(Long value) {
            addCriterion("entry_pic_id <>", value, "entry_pic_id");
            return (Criteria) this;
        }

        public Criteria andEntry_pic_idGreaterThan(Long value) {
            addCriterion("entry_pic_id >", value, "entry_pic_id");
            return (Criteria) this;
        }

        public Criteria andEntry_pic_idGreaterThanOrEqualTo(Long value) {
            addCriterion("entry_pic_id >=", value, "entry_pic_id");
            return (Criteria) this;
        }

        public Criteria andEntry_pic_idLessThan(Long value) {
            addCriterion("entry_pic_id <", value, "entry_pic_id");
            return (Criteria) this;
        }

        public Criteria andEntry_pic_idLessThanOrEqualTo(Long value) {
            addCriterion("entry_pic_id <=", value, "entry_pic_id");
            return (Criteria) this;
        }

        public Criteria andEntry_pic_idIn(List<Long> values) {
            addCriterion("entry_pic_id in", values, "entry_pic_id");
            return (Criteria) this;
        }

        public Criteria andEntry_pic_idNotIn(List<Long> values) {
            addCriterion("entry_pic_id not in", values, "entry_pic_id");
            return (Criteria) this;
        }

        public Criteria andEntry_pic_idBetween(Long value1, Long value2) {
            addCriterion("entry_pic_id between", value1, value2, "entry_pic_id");
            return (Criteria) this;
        }

        public Criteria andEntry_pic_idNotBetween(Long value1, Long value2) {
            addCriterion("entry_pic_id not between", value1, value2, "entry_pic_id");
            return (Criteria) this;
        }

        public Criteria andExit_pic_idIsNull() {
            addCriterion("exit_pic_id is null");
            return (Criteria) this;
        }

        public Criteria andExit_pic_idIsNotNull() {
            addCriterion("exit_pic_id is not null");
            return (Criteria) this;
        }

        public Criteria andExit_pic_idEqualTo(Long value) {
            addCriterion("exit_pic_id =", value, "exit_pic_id");
            return (Criteria) this;
        }

        public Criteria andExit_pic_idNotEqualTo(Long value) {
            addCriterion("exit_pic_id <>", value, "exit_pic_id");
            return (Criteria) this;
        }

        public Criteria andExit_pic_idGreaterThan(Long value) {
            addCriterion("exit_pic_id >", value, "exit_pic_id");
            return (Criteria) this;
        }

        public Criteria andExit_pic_idGreaterThanOrEqualTo(Long value) {
            addCriterion("exit_pic_id >=", value, "exit_pic_id");
            return (Criteria) this;
        }

        public Criteria andExit_pic_idLessThan(Long value) {
            addCriterion("exit_pic_id <", value, "exit_pic_id");
            return (Criteria) this;
        }

        public Criteria andExit_pic_idLessThanOrEqualTo(Long value) {
            addCriterion("exit_pic_id <=", value, "exit_pic_id");
            return (Criteria) this;
        }

        public Criteria andExit_pic_idIn(List<Long> values) {
            addCriterion("exit_pic_id in", values, "exit_pic_id");
            return (Criteria) this;
        }

        public Criteria andExit_pic_idNotIn(List<Long> values) {
            addCriterion("exit_pic_id not in", values, "exit_pic_id");
            return (Criteria) this;
        }

        public Criteria andExit_pic_idBetween(Long value1, Long value2) {
            addCriterion("exit_pic_id between", value1, value2, "exit_pic_id");
            return (Criteria) this;
        }

        public Criteria andExit_pic_idNotBetween(Long value1, Long value2) {
            addCriterion("exit_pic_id not between", value1, value2, "exit_pic_id");
            return (Criteria) this;
        }

        public Criteria andIs_paymentIsNull() {
            addCriterion("is_payment is null");
            return (Criteria) this;
        }

        public Criteria andIs_paymentIsNotNull() {
            addCriterion("is_payment is not null");
            return (Criteria) this;
        }

        public Criteria andIs_paymentEqualTo(Short value) {
            addCriterion("is_payment =", value, "is_payment");
            return (Criteria) this;
        }

        public Criteria andIs_paymentNotEqualTo(Short value) {
            addCriterion("is_payment <>", value, "is_payment");
            return (Criteria) this;
        }

        public Criteria andIs_paymentGreaterThan(Short value) {
            addCriterion("is_payment >", value, "is_payment");
            return (Criteria) this;
        }

        public Criteria andIs_paymentGreaterThanOrEqualTo(Short value) {
            addCriterion("is_payment >=", value, "is_payment");
            return (Criteria) this;
        }

        public Criteria andIs_paymentLessThan(Short value) {
            addCriterion("is_payment <", value, "is_payment");
            return (Criteria) this;
        }

        public Criteria andIs_paymentLessThanOrEqualTo(Short value) {
            addCriterion("is_payment <=", value, "is_payment");
            return (Criteria) this;
        }

        public Criteria andIs_paymentIn(List<Short> values) {
            addCriterion("is_payment in", values, "is_payment");
            return (Criteria) this;
        }

        public Criteria andIs_paymentNotIn(List<Short> values) {
            addCriterion("is_payment not in", values, "is_payment");
            return (Criteria) this;
        }

        public Criteria andIs_paymentBetween(Short value1, Short value2) {
            addCriterion("is_payment between", value1, value2, "is_payment");
            return (Criteria) this;
        }

        public Criteria andIs_paymentNotBetween(Short value1, Short value2) {
            addCriterion("is_payment not between", value1, value2, "is_payment");
            return (Criteria) this;
        }

        public Criteria andPay_timeIsNull() {
            addCriterion("pay_time is null");
            return (Criteria) this;
        }

        public Criteria andPay_timeIsNotNull() {
            addCriterion("pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andPay_timeEqualTo(Date value) {
            addCriterion("pay_time =", value, "pay_time");
            return (Criteria) this;
        }

        public Criteria andPay_timeNotEqualTo(Date value) {
            addCriterion("pay_time <>", value, "pay_time");
            return (Criteria) this;
        }

        public Criteria andPay_timeGreaterThan(Date value) {
            addCriterion("pay_time >", value, "pay_time");
            return (Criteria) this;
        }

        public Criteria andPay_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("pay_time >=", value, "pay_time");
            return (Criteria) this;
        }

        public Criteria andPay_timeLessThan(Date value) {
            addCriterion("pay_time <", value, "pay_time");
            return (Criteria) this;
        }

        public Criteria andPay_timeLessThanOrEqualTo(Date value) {
            addCriterion("pay_time <=", value, "pay_time");
            return (Criteria) this;
        }

        public Criteria andPay_timeIn(List<Date> values) {
            addCriterion("pay_time in", values, "pay_time");
            return (Criteria) this;
        }

        public Criteria andPay_timeNotIn(List<Date> values) {
            addCriterion("pay_time not in", values, "pay_time");
            return (Criteria) this;
        }

        public Criteria andPay_timeBetween(Date value1, Date value2) {
            addCriterion("pay_time between", value1, value2, "pay_time");
            return (Criteria) this;
        }

        public Criteria andPay_timeNotBetween(Date value1, Date value2) {
            addCriterion("pay_time not between", value1, value2, "pay_time");
            return (Criteria) this;
        }

        public Criteria andReal_chargesIsNull() {
            addCriterion("real_charges is null");
            return (Criteria) this;
        }

        public Criteria andReal_chargesIsNotNull() {
            addCriterion("real_charges is not null");
            return (Criteria) this;
        }

        public Criteria andReal_chargesEqualTo(Double value) {
            addCriterion("real_charges =", value, "real_charges");
            return (Criteria) this;
        }

        public Criteria andReal_chargesNotEqualTo(Double value) {
            addCriterion("real_charges <>", value, "real_charges");
            return (Criteria) this;
        }

        public Criteria andReal_chargesGreaterThan(Double value) {
            addCriterion("real_charges >", value, "real_charges");
            return (Criteria) this;
        }

        public Criteria andReal_chargesGreaterThanOrEqualTo(Double value) {
            addCriterion("real_charges >=", value, "real_charges");
            return (Criteria) this;
        }

        public Criteria andReal_chargesLessThan(Double value) {
            addCriterion("real_charges <", value, "real_charges");
            return (Criteria) this;
        }

        public Criteria andReal_chargesLessThanOrEqualTo(Double value) {
            addCriterion("real_charges <=", value, "real_charges");
            return (Criteria) this;
        }

        public Criteria andReal_chargesIn(List<Double> values) {
            addCriterion("real_charges in", values, "real_charges");
            return (Criteria) this;
        }

        public Criteria andReal_chargesNotIn(List<Double> values) {
            addCriterion("real_charges not in", values, "real_charges");
            return (Criteria) this;
        }

        public Criteria andReal_chargesBetween(Double value1, Double value2) {
            addCriterion("real_charges between", value1, value2, "real_charges");
            return (Criteria) this;
        }

        public Criteria andReal_chargesNotBetween(Double value1, Double value2) {
            addCriterion("real_charges not between", value1, value2, "real_charges");
            return (Criteria) this;
        }

        public Criteria andDue_chargesIsNull() {
            addCriterion("due_charges is null");
            return (Criteria) this;
        }

        public Criteria andDue_chargesIsNotNull() {
            addCriterion("due_charges is not null");
            return (Criteria) this;
        }

        public Criteria andDue_chargesEqualTo(Double value) {
            addCriterion("due_charges =", value, "due_charges");
            return (Criteria) this;
        }

        public Criteria andDue_chargesNotEqualTo(Double value) {
            addCriterion("due_charges <>", value, "due_charges");
            return (Criteria) this;
        }

        public Criteria andDue_chargesGreaterThan(Double value) {
            addCriterion("due_charges >", value, "due_charges");
            return (Criteria) this;
        }

        public Criteria andDue_chargesGreaterThanOrEqualTo(Double value) {
            addCriterion("due_charges >=", value, "due_charges");
            return (Criteria) this;
        }

        public Criteria andDue_chargesLessThan(Double value) {
            addCriterion("due_charges <", value, "due_charges");
            return (Criteria) this;
        }

        public Criteria andDue_chargesLessThanOrEqualTo(Double value) {
            addCriterion("due_charges <=", value, "due_charges");
            return (Criteria) this;
        }

        public Criteria andDue_chargesIn(List<Double> values) {
            addCriterion("due_charges in", values, "due_charges");
            return (Criteria) this;
        }

        public Criteria andDue_chargesNotIn(List<Double> values) {
            addCriterion("due_charges not in", values, "due_charges");
            return (Criteria) this;
        }

        public Criteria andDue_chargesBetween(Double value1, Double value2) {
            addCriterion("due_charges between", value1, value2, "due_charges");
            return (Criteria) this;
        }

        public Criteria andDue_chargesNotBetween(Double value1, Double value2) {
            addCriterion("due_charges not between", value1, value2, "due_charges");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}