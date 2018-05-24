package com.yiya.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TabSentryUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TabSentryUserExample() {
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

        public Criteria andUser_nameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUser_nameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUser_nameEqualTo(String value) {
            addCriterion("user_name =", value, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameGreaterThan(String value) {
            addCriterion("user_name >", value, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameLessThan(String value) {
            addCriterion("user_name <", value, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameLike(String value) {
            addCriterion("user_name like", value, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameNotLike(String value) {
            addCriterion("user_name not like", value, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameIn(List<String> values) {
            addCriterion("user_name in", values, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_pwdIsNull() {
            addCriterion("user_pwd is null");
            return (Criteria) this;
        }

        public Criteria andUser_pwdIsNotNull() {
            addCriterion("user_pwd is not null");
            return (Criteria) this;
        }

        public Criteria andUser_pwdEqualTo(String value) {
            addCriterion("user_pwd =", value, "user_pwd");
            return (Criteria) this;
        }

        public Criteria andUser_pwdNotEqualTo(String value) {
            addCriterion("user_pwd <>", value, "user_pwd");
            return (Criteria) this;
        }

        public Criteria andUser_pwdGreaterThan(String value) {
            addCriterion("user_pwd >", value, "user_pwd");
            return (Criteria) this;
        }

        public Criteria andUser_pwdGreaterThanOrEqualTo(String value) {
            addCriterion("user_pwd >=", value, "user_pwd");
            return (Criteria) this;
        }

        public Criteria andUser_pwdLessThan(String value) {
            addCriterion("user_pwd <", value, "user_pwd");
            return (Criteria) this;
        }

        public Criteria andUser_pwdLessThanOrEqualTo(String value) {
            addCriterion("user_pwd <=", value, "user_pwd");
            return (Criteria) this;
        }

        public Criteria andUser_pwdLike(String value) {
            addCriterion("user_pwd like", value, "user_pwd");
            return (Criteria) this;
        }

        public Criteria andUser_pwdNotLike(String value) {
            addCriterion("user_pwd not like", value, "user_pwd");
            return (Criteria) this;
        }

        public Criteria andUser_pwdIn(List<String> values) {
            addCriterion("user_pwd in", values, "user_pwd");
            return (Criteria) this;
        }

        public Criteria andUser_pwdNotIn(List<String> values) {
            addCriterion("user_pwd not in", values, "user_pwd");
            return (Criteria) this;
        }

        public Criteria andUser_pwdBetween(String value1, String value2) {
            addCriterion("user_pwd between", value1, value2, "user_pwd");
            return (Criteria) this;
        }

        public Criteria andUser_pwdNotBetween(String value1, String value2) {
            addCriterion("user_pwd not between", value1, value2, "user_pwd");
            return (Criteria) this;
        }

        public Criteria andReal_nameIsNull() {
            addCriterion("real_name is null");
            return (Criteria) this;
        }

        public Criteria andReal_nameIsNotNull() {
            addCriterion("real_name is not null");
            return (Criteria) this;
        }

        public Criteria andReal_nameEqualTo(String value) {
            addCriterion("real_name =", value, "real_name");
            return (Criteria) this;
        }

        public Criteria andReal_nameNotEqualTo(String value) {
            addCriterion("real_name <>", value, "real_name");
            return (Criteria) this;
        }

        public Criteria andReal_nameGreaterThan(String value) {
            addCriterion("real_name >", value, "real_name");
            return (Criteria) this;
        }

        public Criteria andReal_nameGreaterThanOrEqualTo(String value) {
            addCriterion("real_name >=", value, "real_name");
            return (Criteria) this;
        }

        public Criteria andReal_nameLessThan(String value) {
            addCriterion("real_name <", value, "real_name");
            return (Criteria) this;
        }

        public Criteria andReal_nameLessThanOrEqualTo(String value) {
            addCriterion("real_name <=", value, "real_name");
            return (Criteria) this;
        }

        public Criteria andReal_nameLike(String value) {
            addCriterion("real_name like", value, "real_name");
            return (Criteria) this;
        }

        public Criteria andReal_nameNotLike(String value) {
            addCriterion("real_name not like", value, "real_name");
            return (Criteria) this;
        }

        public Criteria andReal_nameIn(List<String> values) {
            addCriterion("real_name in", values, "real_name");
            return (Criteria) this;
        }

        public Criteria andReal_nameNotIn(List<String> values) {
            addCriterion("real_name not in", values, "real_name");
            return (Criteria) this;
        }

        public Criteria andReal_nameBetween(String value1, String value2) {
            addCriterion("real_name between", value1, value2, "real_name");
            return (Criteria) this;
        }

        public Criteria andReal_nameNotBetween(String value1, String value2) {
            addCriterion("real_name not between", value1, value2, "real_name");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Short value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Short value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Short value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Short value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Short value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Short value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Short> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Short> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Short value1, Short value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Short value1, Short value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andCrete_timeIsNull() {
            addCriterion("crete_time is null");
            return (Criteria) this;
        }

        public Criteria andCrete_timeIsNotNull() {
            addCriterion("crete_time is not null");
            return (Criteria) this;
        }

        public Criteria andCrete_timeEqualTo(Date value) {
            addCriterion("crete_time =", value, "crete_time");
            return (Criteria) this;
        }

        public Criteria andCrete_timeNotEqualTo(Date value) {
            addCriterion("crete_time <>", value, "crete_time");
            return (Criteria) this;
        }

        public Criteria andCrete_timeGreaterThan(Date value) {
            addCriterion("crete_time >", value, "crete_time");
            return (Criteria) this;
        }

        public Criteria andCrete_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("crete_time >=", value, "crete_time");
            return (Criteria) this;
        }

        public Criteria andCrete_timeLessThan(Date value) {
            addCriterion("crete_time <", value, "crete_time");
            return (Criteria) this;
        }

        public Criteria andCrete_timeLessThanOrEqualTo(Date value) {
            addCriterion("crete_time <=", value, "crete_time");
            return (Criteria) this;
        }

        public Criteria andCrete_timeIn(List<Date> values) {
            addCriterion("crete_time in", values, "crete_time");
            return (Criteria) this;
        }

        public Criteria andCrete_timeNotIn(List<Date> values) {
            addCriterion("crete_time not in", values, "crete_time");
            return (Criteria) this;
        }

        public Criteria andCrete_timeBetween(Date value1, Date value2) {
            addCriterion("crete_time between", value1, value2, "crete_time");
            return (Criteria) this;
        }

        public Criteria andCrete_timeNotBetween(Date value1, Date value2) {
            addCriterion("crete_time not between", value1, value2, "crete_time");
            return (Criteria) this;
        }

        public Criteria andLogin_timeIsNull() {
            addCriterion("login_time is null");
            return (Criteria) this;
        }

        public Criteria andLogin_timeIsNotNull() {
            addCriterion("login_time is not null");
            return (Criteria) this;
        }

        public Criteria andLogin_timeEqualTo(Date value) {
            addCriterion("login_time =", value, "login_time");
            return (Criteria) this;
        }

        public Criteria andLogin_timeNotEqualTo(Date value) {
            addCriterion("login_time <>", value, "login_time");
            return (Criteria) this;
        }

        public Criteria andLogin_timeGreaterThan(Date value) {
            addCriterion("login_time >", value, "login_time");
            return (Criteria) this;
        }

        public Criteria andLogin_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("login_time >=", value, "login_time");
            return (Criteria) this;
        }

        public Criteria andLogin_timeLessThan(Date value) {
            addCriterion("login_time <", value, "login_time");
            return (Criteria) this;
        }

        public Criteria andLogin_timeLessThanOrEqualTo(Date value) {
            addCriterion("login_time <=", value, "login_time");
            return (Criteria) this;
        }

        public Criteria andLogin_timeIn(List<Date> values) {
            addCriterion("login_time in", values, "login_time");
            return (Criteria) this;
        }

        public Criteria andLogin_timeNotIn(List<Date> values) {
            addCriterion("login_time not in", values, "login_time");
            return (Criteria) this;
        }

        public Criteria andLogin_timeBetween(Date value1, Date value2) {
            addCriterion("login_time between", value1, value2, "login_time");
            return (Criteria) this;
        }

        public Criteria andLogin_timeNotBetween(Date value1, Date value2) {
            addCriterion("login_time not between", value1, value2, "login_time");
            return (Criteria) this;
        }

        public Criteria andLogin_cntIsNull() {
            addCriterion("login_cnt is null");
            return (Criteria) this;
        }

        public Criteria andLogin_cntIsNotNull() {
            addCriterion("login_cnt is not null");
            return (Criteria) this;
        }

        public Criteria andLogin_cntEqualTo(Integer value) {
            addCriterion("login_cnt =", value, "login_cnt");
            return (Criteria) this;
        }

        public Criteria andLogin_cntNotEqualTo(Integer value) {
            addCriterion("login_cnt <>", value, "login_cnt");
            return (Criteria) this;
        }

        public Criteria andLogin_cntGreaterThan(Integer value) {
            addCriterion("login_cnt >", value, "login_cnt");
            return (Criteria) this;
        }

        public Criteria andLogin_cntGreaterThanOrEqualTo(Integer value) {
            addCriterion("login_cnt >=", value, "login_cnt");
            return (Criteria) this;
        }

        public Criteria andLogin_cntLessThan(Integer value) {
            addCriterion("login_cnt <", value, "login_cnt");
            return (Criteria) this;
        }

        public Criteria andLogin_cntLessThanOrEqualTo(Integer value) {
            addCriterion("login_cnt <=", value, "login_cnt");
            return (Criteria) this;
        }

        public Criteria andLogin_cntIn(List<Integer> values) {
            addCriterion("login_cnt in", values, "login_cnt");
            return (Criteria) this;
        }

        public Criteria andLogin_cntNotIn(List<Integer> values) {
            addCriterion("login_cnt not in", values, "login_cnt");
            return (Criteria) this;
        }

        public Criteria andLogin_cntBetween(Integer value1, Integer value2) {
            addCriterion("login_cnt between", value1, value2, "login_cnt");
            return (Criteria) this;
        }

        public Criteria andLogin_cntNotBetween(Integer value1, Integer value2) {
            addCriterion("login_cnt not between", value1, value2, "login_cnt");
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