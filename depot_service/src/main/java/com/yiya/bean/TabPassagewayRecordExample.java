package com.yiya.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TabPassagewayRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TabPassagewayRecordExample() {
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

        public Criteria andPassageway_record_idIsNull() {
            addCriterion("passageway_record_id is null");
            return (Criteria) this;
        }

        public Criteria andPassageway_record_idIsNotNull() {
            addCriterion("passageway_record_id is not null");
            return (Criteria) this;
        }

        public Criteria andPassageway_record_idEqualTo(Long value) {
            addCriterion("passageway_record_id =", value, "passageway_record_id");
            return (Criteria) this;
        }

        public Criteria andPassageway_record_idNotEqualTo(Long value) {
            addCriterion("passageway_record_id <>", value, "passageway_record_id");
            return (Criteria) this;
        }

        public Criteria andPassageway_record_idGreaterThan(Long value) {
            addCriterion("passageway_record_id >", value, "passageway_record_id");
            return (Criteria) this;
        }

        public Criteria andPassageway_record_idGreaterThanOrEqualTo(Long value) {
            addCriterion("passageway_record_id >=", value, "passageway_record_id");
            return (Criteria) this;
        }

        public Criteria andPassageway_record_idLessThan(Long value) {
            addCriterion("passageway_record_id <", value, "passageway_record_id");
            return (Criteria) this;
        }

        public Criteria andPassageway_record_idLessThanOrEqualTo(Long value) {
            addCriterion("passageway_record_id <=", value, "passageway_record_id");
            return (Criteria) this;
        }

        public Criteria andPassageway_record_idIn(List<Long> values) {
            addCriterion("passageway_record_id in", values, "passageway_record_id");
            return (Criteria) this;
        }

        public Criteria andPassageway_record_idNotIn(List<Long> values) {
            addCriterion("passageway_record_id not in", values, "passageway_record_id");
            return (Criteria) this;
        }

        public Criteria andPassageway_record_idBetween(Long value1, Long value2) {
            addCriterion("passageway_record_id between", value1, value2, "passageway_record_id");
            return (Criteria) this;
        }

        public Criteria andPassageway_record_idNotBetween(Long value1, Long value2) {
            addCriterion("passageway_record_id not between", value1, value2, "passageway_record_id");
            return (Criteria) this;
        }

        public Criteria andPassageway_typeIsNull() {
            addCriterion("passageway_type is null");
            return (Criteria) this;
        }

        public Criteria andPassageway_typeIsNotNull() {
            addCriterion("passageway_type is not null");
            return (Criteria) this;
        }

        public Criteria andPassageway_typeEqualTo(Short value) {
            addCriterion("passageway_type =", value, "passageway_type");
            return (Criteria) this;
        }

        public Criteria andPassageway_typeNotEqualTo(Short value) {
            addCriterion("passageway_type <>", value, "passageway_type");
            return (Criteria) this;
        }

        public Criteria andPassageway_typeGreaterThan(Short value) {
            addCriterion("passageway_type >", value, "passageway_type");
            return (Criteria) this;
        }

        public Criteria andPassageway_typeGreaterThanOrEqualTo(Short value) {
            addCriterion("passageway_type >=", value, "passageway_type");
            return (Criteria) this;
        }

        public Criteria andPassageway_typeLessThan(Short value) {
            addCriterion("passageway_type <", value, "passageway_type");
            return (Criteria) this;
        }

        public Criteria andPassageway_typeLessThanOrEqualTo(Short value) {
            addCriterion("passageway_type <=", value, "passageway_type");
            return (Criteria) this;
        }

        public Criteria andPassageway_typeIn(List<Short> values) {
            addCriterion("passageway_type in", values, "passageway_type");
            return (Criteria) this;
        }

        public Criteria andPassageway_typeNotIn(List<Short> values) {
            addCriterion("passageway_type not in", values, "passageway_type");
            return (Criteria) this;
        }

        public Criteria andPassageway_typeBetween(Short value1, Short value2) {
            addCriterion("passageway_type between", value1, value2, "passageway_type");
            return (Criteria) this;
        }

        public Criteria andPassageway_typeNotBetween(Short value1, Short value2) {
            addCriterion("passageway_type not between", value1, value2, "passageway_type");
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

        public Criteria andAccess_typeIsNull() {
            addCriterion("access_type is null");
            return (Criteria) this;
        }

        public Criteria andAccess_typeIsNotNull() {
            addCriterion("access_type is not null");
            return (Criteria) this;
        }

        public Criteria andAccess_typeEqualTo(Short value) {
            addCriterion("access_type =", value, "access_type");
            return (Criteria) this;
        }

        public Criteria andAccess_typeNotEqualTo(Short value) {
            addCriterion("access_type <>", value, "access_type");
            return (Criteria) this;
        }

        public Criteria andAccess_typeGreaterThan(Short value) {
            addCriterion("access_type >", value, "access_type");
            return (Criteria) this;
        }

        public Criteria andAccess_typeGreaterThanOrEqualTo(Short value) {
            addCriterion("access_type >=", value, "access_type");
            return (Criteria) this;
        }

        public Criteria andAccess_typeLessThan(Short value) {
            addCriterion("access_type <", value, "access_type");
            return (Criteria) this;
        }

        public Criteria andAccess_typeLessThanOrEqualTo(Short value) {
            addCriterion("access_type <=", value, "access_type");
            return (Criteria) this;
        }

        public Criteria andAccess_typeIn(List<Short> values) {
            addCriterion("access_type in", values, "access_type");
            return (Criteria) this;
        }

        public Criteria andAccess_typeNotIn(List<Short> values) {
            addCriterion("access_type not in", values, "access_type");
            return (Criteria) this;
        }

        public Criteria andAccess_typeBetween(Short value1, Short value2) {
            addCriterion("access_type between", value1, value2, "access_type");
            return (Criteria) this;
        }

        public Criteria andAccess_typeNotBetween(Short value1, Short value2) {
            addCriterion("access_type not between", value1, value2, "access_type");
            return (Criteria) this;
        }

        public Criteria andAccess_propertyIsNull() {
            addCriterion("access_property is null");
            return (Criteria) this;
        }

        public Criteria andAccess_propertyIsNotNull() {
            addCriterion("access_property is not null");
            return (Criteria) this;
        }

        public Criteria andAccess_propertyEqualTo(Short value) {
            addCriterion("access_property =", value, "access_property");
            return (Criteria) this;
        }

        public Criteria andAccess_propertyNotEqualTo(Short value) {
            addCriterion("access_property <>", value, "access_property");
            return (Criteria) this;
        }

        public Criteria andAccess_propertyGreaterThan(Short value) {
            addCriterion("access_property >", value, "access_property");
            return (Criteria) this;
        }

        public Criteria andAccess_propertyGreaterThanOrEqualTo(Short value) {
            addCriterion("access_property >=", value, "access_property");
            return (Criteria) this;
        }

        public Criteria andAccess_propertyLessThan(Short value) {
            addCriterion("access_property <", value, "access_property");
            return (Criteria) this;
        }

        public Criteria andAccess_propertyLessThanOrEqualTo(Short value) {
            addCriterion("access_property <=", value, "access_property");
            return (Criteria) this;
        }

        public Criteria andAccess_propertyIn(List<Short> values) {
            addCriterion("access_property in", values, "access_property");
            return (Criteria) this;
        }

        public Criteria andAccess_propertyNotIn(List<Short> values) {
            addCriterion("access_property not in", values, "access_property");
            return (Criteria) this;
        }

        public Criteria andAccess_propertyBetween(Short value1, Short value2) {
            addCriterion("access_property between", value1, value2, "access_property");
            return (Criteria) this;
        }

        public Criteria andAccess_propertyNotBetween(Short value1, Short value2) {
            addCriterion("access_property not between", value1, value2, "access_property");
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

        public Criteria andCreate_timeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreate_timeEqualTo(Date value) {
            addCriterion("create_time =", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeGreaterThan(Date value) {
            addCriterion("create_time >", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeLessThan(Date value) {
            addCriterion("create_time <", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIn(List<Date> values) {
            addCriterion("create_time in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "create_time");
            return (Criteria) this;
        }

        public Criteria andEntry_typeIsNull() {
            addCriterion("entry_type is null");
            return (Criteria) this;
        }

        public Criteria andEntry_typeIsNotNull() {
            addCriterion("entry_type is not null");
            return (Criteria) this;
        }

        public Criteria andEntry_typeEqualTo(Short value) {
            addCriterion("entry_type =", value, "entry_type");
            return (Criteria) this;
        }

        public Criteria andEntry_typeNotEqualTo(Short value) {
            addCriterion("entry_type <>", value, "entry_type");
            return (Criteria) this;
        }

        public Criteria andEntry_typeGreaterThan(Short value) {
            addCriterion("entry_type >", value, "entry_type");
            return (Criteria) this;
        }

        public Criteria andEntry_typeGreaterThanOrEqualTo(Short value) {
            addCriterion("entry_type >=", value, "entry_type");
            return (Criteria) this;
        }

        public Criteria andEntry_typeLessThan(Short value) {
            addCriterion("entry_type <", value, "entry_type");
            return (Criteria) this;
        }

        public Criteria andEntry_typeLessThanOrEqualTo(Short value) {
            addCriterion("entry_type <=", value, "entry_type");
            return (Criteria) this;
        }

        public Criteria andEntry_typeIn(List<Short> values) {
            addCriterion("entry_type in", values, "entry_type");
            return (Criteria) this;
        }

        public Criteria andEntry_typeNotIn(List<Short> values) {
            addCriterion("entry_type not in", values, "entry_type");
            return (Criteria) this;
        }

        public Criteria andEntry_typeBetween(Short value1, Short value2) {
            addCriterion("entry_type between", value1, value2, "entry_type");
            return (Criteria) this;
        }

        public Criteria andEntry_typeNotBetween(Short value1, Short value2) {
            addCriterion("entry_type not between", value1, value2, "entry_type");
            return (Criteria) this;
        }

        public Criteria andIs_succeedIsNull() {
            addCriterion("is_succeed is null");
            return (Criteria) this;
        }

        public Criteria andIs_succeedIsNotNull() {
            addCriterion("is_succeed is not null");
            return (Criteria) this;
        }

        public Criteria andIs_succeedEqualTo(Short value) {
            addCriterion("is_succeed =", value, "is_succeed");
            return (Criteria) this;
        }

        public Criteria andIs_succeedNotEqualTo(Short value) {
            addCriterion("is_succeed <>", value, "is_succeed");
            return (Criteria) this;
        }

        public Criteria andIs_succeedGreaterThan(Short value) {
            addCriterion("is_succeed >", value, "is_succeed");
            return (Criteria) this;
        }

        public Criteria andIs_succeedGreaterThanOrEqualTo(Short value) {
            addCriterion("is_succeed >=", value, "is_succeed");
            return (Criteria) this;
        }

        public Criteria andIs_succeedLessThan(Short value) {
            addCriterion("is_succeed <", value, "is_succeed");
            return (Criteria) this;
        }

        public Criteria andIs_succeedLessThanOrEqualTo(Short value) {
            addCriterion("is_succeed <=", value, "is_succeed");
            return (Criteria) this;
        }

        public Criteria andIs_succeedIn(List<Short> values) {
            addCriterion("is_succeed in", values, "is_succeed");
            return (Criteria) this;
        }

        public Criteria andIs_succeedNotIn(List<Short> values) {
            addCriterion("is_succeed not in", values, "is_succeed");
            return (Criteria) this;
        }

        public Criteria andIs_succeedBetween(Short value1, Short value2) {
            addCriterion("is_succeed between", value1, value2, "is_succeed");
            return (Criteria) this;
        }

        public Criteria andIs_succeedNotBetween(Short value1, Short value2) {
            addCriterion("is_succeed not between", value1, value2, "is_succeed");
            return (Criteria) this;
        }

        public Criteria andFailure_reasonIsNull() {
            addCriterion("failure_reason is null");
            return (Criteria) this;
        }

        public Criteria andFailure_reasonIsNotNull() {
            addCriterion("failure_reason is not null");
            return (Criteria) this;
        }

        public Criteria andFailure_reasonEqualTo(String value) {
            addCriterion("failure_reason =", value, "failure_reason");
            return (Criteria) this;
        }

        public Criteria andFailure_reasonNotEqualTo(String value) {
            addCriterion("failure_reason <>", value, "failure_reason");
            return (Criteria) this;
        }

        public Criteria andFailure_reasonGreaterThan(String value) {
            addCriterion("failure_reason >", value, "failure_reason");
            return (Criteria) this;
        }

        public Criteria andFailure_reasonGreaterThanOrEqualTo(String value) {
            addCriterion("failure_reason >=", value, "failure_reason");
            return (Criteria) this;
        }

        public Criteria andFailure_reasonLessThan(String value) {
            addCriterion("failure_reason <", value, "failure_reason");
            return (Criteria) this;
        }

        public Criteria andFailure_reasonLessThanOrEqualTo(String value) {
            addCriterion("failure_reason <=", value, "failure_reason");
            return (Criteria) this;
        }

        public Criteria andFailure_reasonLike(String value) {
            addCriterion("failure_reason like", value, "failure_reason");
            return (Criteria) this;
        }

        public Criteria andFailure_reasonNotLike(String value) {
            addCriterion("failure_reason not like", value, "failure_reason");
            return (Criteria) this;
        }

        public Criteria andFailure_reasonIn(List<String> values) {
            addCriterion("failure_reason in", values, "failure_reason");
            return (Criteria) this;
        }

        public Criteria andFailure_reasonNotIn(List<String> values) {
            addCriterion("failure_reason not in", values, "failure_reason");
            return (Criteria) this;
        }

        public Criteria andFailure_reasonBetween(String value1, String value2) {
            addCriterion("failure_reason between", value1, value2, "failure_reason");
            return (Criteria) this;
        }

        public Criteria andFailure_reasonNotBetween(String value1, String value2) {
            addCriterion("failure_reason not between", value1, value2, "failure_reason");
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