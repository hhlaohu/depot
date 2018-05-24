package com.yiya.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TabFreeInOutListExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TabFreeInOutListExample() {
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

        public Criteria andFree_in_out_idIsNull() {
            addCriterion("free_in_out_id is null");
            return (Criteria) this;
        }

        public Criteria andFree_in_out_idIsNotNull() {
            addCriterion("free_in_out_id is not null");
            return (Criteria) this;
        }

        public Criteria andFree_in_out_idEqualTo(Integer value) {
            addCriterion("free_in_out_id =", value, "free_in_out_id");
            return (Criteria) this;
        }

        public Criteria andFree_in_out_idNotEqualTo(Integer value) {
            addCriterion("free_in_out_id <>", value, "free_in_out_id");
            return (Criteria) this;
        }

        public Criteria andFree_in_out_idGreaterThan(Integer value) {
            addCriterion("free_in_out_id >", value, "free_in_out_id");
            return (Criteria) this;
        }

        public Criteria andFree_in_out_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("free_in_out_id >=", value, "free_in_out_id");
            return (Criteria) this;
        }

        public Criteria andFree_in_out_idLessThan(Integer value) {
            addCriterion("free_in_out_id <", value, "free_in_out_id");
            return (Criteria) this;
        }

        public Criteria andFree_in_out_idLessThanOrEqualTo(Integer value) {
            addCriterion("free_in_out_id <=", value, "free_in_out_id");
            return (Criteria) this;
        }

        public Criteria andFree_in_out_idIn(List<Integer> values) {
            addCriterion("free_in_out_id in", values, "free_in_out_id");
            return (Criteria) this;
        }

        public Criteria andFree_in_out_idNotIn(List<Integer> values) {
            addCriterion("free_in_out_id not in", values, "free_in_out_id");
            return (Criteria) this;
        }

        public Criteria andFree_in_out_idBetween(Integer value1, Integer value2) {
            addCriterion("free_in_out_id between", value1, value2, "free_in_out_id");
            return (Criteria) this;
        }

        public Criteria andFree_in_out_idNotBetween(Integer value1, Integer value2) {
            addCriterion("free_in_out_id not between", value1, value2, "free_in_out_id");
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

        public Criteria andLicense_plate_allIsNull() {
            addCriterion("license_plate_all is null");
            return (Criteria) this;
        }

        public Criteria andLicense_plate_allIsNotNull() {
            addCriterion("license_plate_all is not null");
            return (Criteria) this;
        }

        public Criteria andLicense_plate_allEqualTo(String value) {
            addCriterion("license_plate_all =", value, "license_plate_all");
            return (Criteria) this;
        }

        public Criteria andLicense_plate_allNotEqualTo(String value) {
            addCriterion("license_plate_all <>", value, "license_plate_all");
            return (Criteria) this;
        }

        public Criteria andLicense_plate_allGreaterThan(String value) {
            addCriterion("license_plate_all >", value, "license_plate_all");
            return (Criteria) this;
        }

        public Criteria andLicense_plate_allGreaterThanOrEqualTo(String value) {
            addCriterion("license_plate_all >=", value, "license_plate_all");
            return (Criteria) this;
        }

        public Criteria andLicense_plate_allLessThan(String value) {
            addCriterion("license_plate_all <", value, "license_plate_all");
            return (Criteria) this;
        }

        public Criteria andLicense_plate_allLessThanOrEqualTo(String value) {
            addCriterion("license_plate_all <=", value, "license_plate_all");
            return (Criteria) this;
        }

        public Criteria andLicense_plate_allLike(String value) {
            addCriterion("license_plate_all like", value, "license_plate_all");
            return (Criteria) this;
        }

        public Criteria andLicense_plate_allNotLike(String value) {
            addCriterion("license_plate_all not like", value, "license_plate_all");
            return (Criteria) this;
        }

        public Criteria andLicense_plate_allIn(List<String> values) {
            addCriterion("license_plate_all in", values, "license_plate_all");
            return (Criteria) this;
        }

        public Criteria andLicense_plate_allNotIn(List<String> values) {
            addCriterion("license_plate_all not in", values, "license_plate_all");
            return (Criteria) this;
        }

        public Criteria andLicense_plate_allBetween(String value1, String value2) {
            addCriterion("license_plate_all between", value1, value2, "license_plate_all");
            return (Criteria) this;
        }

        public Criteria andLicense_plate_allNotBetween(String value1, String value2) {
            addCriterion("license_plate_all not between", value1, value2, "license_plate_all");
            return (Criteria) this;
        }

        public Criteria andBegin_timeIsNull() {
            addCriterion("begin_time is null");
            return (Criteria) this;
        }

        public Criteria andBegin_timeIsNotNull() {
            addCriterion("begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andBegin_timeEqualTo(Date value) {
            addCriterion("begin_time =", value, "begin_time");
            return (Criteria) this;
        }

        public Criteria andBegin_timeNotEqualTo(Date value) {
            addCriterion("begin_time <>", value, "begin_time");
            return (Criteria) this;
        }

        public Criteria andBegin_timeGreaterThan(Date value) {
            addCriterion("begin_time >", value, "begin_time");
            return (Criteria) this;
        }

        public Criteria andBegin_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("begin_time >=", value, "begin_time");
            return (Criteria) this;
        }

        public Criteria andBegin_timeLessThan(Date value) {
            addCriterion("begin_time <", value, "begin_time");
            return (Criteria) this;
        }

        public Criteria andBegin_timeLessThanOrEqualTo(Date value) {
            addCriterion("begin_time <=", value, "begin_time");
            return (Criteria) this;
        }

        public Criteria andBegin_timeIn(List<Date> values) {
            addCriterion("begin_time in", values, "begin_time");
            return (Criteria) this;
        }

        public Criteria andBegin_timeNotIn(List<Date> values) {
            addCriterion("begin_time not in", values, "begin_time");
            return (Criteria) this;
        }

        public Criteria andBegin_timeBetween(Date value1, Date value2) {
            addCriterion("begin_time between", value1, value2, "begin_time");
            return (Criteria) this;
        }

        public Criteria andBegin_timeNotBetween(Date value1, Date value2) {
            addCriterion("begin_time not between", value1, value2, "begin_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEnd_timeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEnd_timeEqualTo(Date value) {
            addCriterion("end_time =", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeGreaterThan(Date value) {
            addCriterion("end_time >", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeLessThan(Date value) {
            addCriterion("end_time <", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeIn(List<Date> values) {
            addCriterion("end_time in", values, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "end_time");
            return (Criteria) this;
        }

        public Criteria andFree_typeIsNull() {
            addCriterion("free_type is null");
            return (Criteria) this;
        }

        public Criteria andFree_typeIsNotNull() {
            addCriterion("free_type is not null");
            return (Criteria) this;
        }

        public Criteria andFree_typeEqualTo(Short value) {
            addCriterion("free_type =", value, "free_type");
            return (Criteria) this;
        }

        public Criteria andFree_typeNotEqualTo(Short value) {
            addCriterion("free_type <>", value, "free_type");
            return (Criteria) this;
        }

        public Criteria andFree_typeGreaterThan(Short value) {
            addCriterion("free_type >", value, "free_type");
            return (Criteria) this;
        }

        public Criteria andFree_typeGreaterThanOrEqualTo(Short value) {
            addCriterion("free_type >=", value, "free_type");
            return (Criteria) this;
        }

        public Criteria andFree_typeLessThan(Short value) {
            addCriterion("free_type <", value, "free_type");
            return (Criteria) this;
        }

        public Criteria andFree_typeLessThanOrEqualTo(Short value) {
            addCriterion("free_type <=", value, "free_type");
            return (Criteria) this;
        }

        public Criteria andFree_typeIn(List<Short> values) {
            addCriterion("free_type in", values, "free_type");
            return (Criteria) this;
        }

        public Criteria andFree_typeNotIn(List<Short> values) {
            addCriterion("free_type not in", values, "free_type");
            return (Criteria) this;
        }

        public Criteria andFree_typeBetween(Short value1, Short value2) {
            addCriterion("free_type between", value1, value2, "free_type");
            return (Criteria) this;
        }

        public Criteria andFree_typeNotBetween(Short value1, Short value2) {
            addCriterion("free_type not between", value1, value2, "free_type");
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