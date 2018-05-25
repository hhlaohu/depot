package com.yiya.bean;

import java.util.ArrayList;
import java.util.List;

public class TabPassagewayPictureExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TabPassagewayPictureExample() {
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

        public Criteria andPassageway_pic_idIsNull() {
            addCriterion("passageway_pic_id is null");
            return (Criteria) this;
        }

        public Criteria andPassageway_pic_idIsNotNull() {
            addCriterion("passageway_pic_id is not null");
            return (Criteria) this;
        }

        public Criteria andPassageway_pic_idEqualTo(Long value) {
            addCriterion("passageway_pic_id =", value, "passageway_pic_id");
            return (Criteria) this;
        }

        public Criteria andPassageway_pic_idNotEqualTo(Long value) {
            addCriterion("passageway_pic_id <>", value, "passageway_pic_id");
            return (Criteria) this;
        }

        public Criteria andPassageway_pic_idGreaterThan(Long value) {
            addCriterion("passageway_pic_id >", value, "passageway_pic_id");
            return (Criteria) this;
        }

        public Criteria andPassageway_pic_idGreaterThanOrEqualTo(Long value) {
            addCriterion("passageway_pic_id >=", value, "passageway_pic_id");
            return (Criteria) this;
        }

        public Criteria andPassageway_pic_idLessThan(Long value) {
            addCriterion("passageway_pic_id <", value, "passageway_pic_id");
            return (Criteria) this;
        }

        public Criteria andPassageway_pic_idLessThanOrEqualTo(Long value) {
            addCriterion("passageway_pic_id <=", value, "passageway_pic_id");
            return (Criteria) this;
        }

        public Criteria andPassageway_pic_idIn(List<Long> values) {
            addCriterion("passageway_pic_id in", values, "passageway_pic_id");
            return (Criteria) this;
        }

        public Criteria andPassageway_pic_idNotIn(List<Long> values) {
            addCriterion("passageway_pic_id not in", values, "passageway_pic_id");
            return (Criteria) this;
        }

        public Criteria andPassageway_pic_idBetween(Long value1, Long value2) {
            addCriterion("passageway_pic_id between", value1, value2, "passageway_pic_id");
            return (Criteria) this;
        }

        public Criteria andPassageway_pic_idNotBetween(Long value1, Long value2) {
            addCriterion("passageway_pic_id not between", value1, value2, "passageway_pic_id");
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

        public Criteria andPic_scoreIsNull() {
            addCriterion("pic_score is null");
            return (Criteria) this;
        }

        public Criteria andPic_scoreIsNotNull() {
            addCriterion("pic_score is not null");
            return (Criteria) this;
        }

        public Criteria andPic_scoreEqualTo(Double value) {
            addCriterion("pic_score =", value, "pic_score");
            return (Criteria) this;
        }

        public Criteria andPic_scoreNotEqualTo(Double value) {
            addCriterion("pic_score <>", value, "pic_score");
            return (Criteria) this;
        }

        public Criteria andPic_scoreGreaterThan(Double value) {
            addCriterion("pic_score >", value, "pic_score");
            return (Criteria) this;
        }

        public Criteria andPic_scoreGreaterThanOrEqualTo(Double value) {
            addCriterion("pic_score >=", value, "pic_score");
            return (Criteria) this;
        }

        public Criteria andPic_scoreLessThan(Double value) {
            addCriterion("pic_score <", value, "pic_score");
            return (Criteria) this;
        }

        public Criteria andPic_scoreLessThanOrEqualTo(Double value) {
            addCriterion("pic_score <=", value, "pic_score");
            return (Criteria) this;
        }

        public Criteria andPic_scoreIn(List<Double> values) {
            addCriterion("pic_score in", values, "pic_score");
            return (Criteria) this;
        }

        public Criteria andPic_scoreNotIn(List<Double> values) {
            addCriterion("pic_score not in", values, "pic_score");
            return (Criteria) this;
        }

        public Criteria andPic_scoreBetween(Double value1, Double value2) {
            addCriterion("pic_score between", value1, value2, "pic_score");
            return (Criteria) this;
        }

        public Criteria andPic_scoreNotBetween(Double value1, Double value2) {
            addCriterion("pic_score not between", value1, value2, "pic_score");
            return (Criteria) this;
        }

        public Criteria andPic_addressIsNull() {
            addCriterion("pic_address is null");
            return (Criteria) this;
        }

        public Criteria andPic_addressIsNotNull() {
            addCriterion("pic_address is not null");
            return (Criteria) this;
        }

        public Criteria andPic_addressEqualTo(String value) {
            addCriterion("pic_address =", value, "pic_address");
            return (Criteria) this;
        }

        public Criteria andPic_addressNotEqualTo(String value) {
            addCriterion("pic_address <>", value, "pic_address");
            return (Criteria) this;
        }

        public Criteria andPic_addressGreaterThan(String value) {
            addCriterion("pic_address >", value, "pic_address");
            return (Criteria) this;
        }

        public Criteria andPic_addressGreaterThanOrEqualTo(String value) {
            addCriterion("pic_address >=", value, "pic_address");
            return (Criteria) this;
        }

        public Criteria andPic_addressLessThan(String value) {
            addCriterion("pic_address <", value, "pic_address");
            return (Criteria) this;
        }

        public Criteria andPic_addressLessThanOrEqualTo(String value) {
            addCriterion("pic_address <=", value, "pic_address");
            return (Criteria) this;
        }

        public Criteria andPic_addressLike(String value) {
            addCriterion("pic_address like", value, "pic_address");
            return (Criteria) this;
        }

        public Criteria andPic_addressNotLike(String value) {
            addCriterion("pic_address not like", value, "pic_address");
            return (Criteria) this;
        }

        public Criteria andPic_addressIn(List<String> values) {
            addCriterion("pic_address in", values, "pic_address");
            return (Criteria) this;
        }

        public Criteria andPic_addressNotIn(List<String> values) {
            addCriterion("pic_address not in", values, "pic_address");
            return (Criteria) this;
        }

        public Criteria andPic_addressBetween(String value1, String value2) {
            addCriterion("pic_address between", value1, value2, "pic_address");
            return (Criteria) this;
        }

        public Criteria andPic_addressNotBetween(String value1, String value2) {
            addCriterion("pic_address not between", value1, value2, "pic_address");
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