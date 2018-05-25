package com.yiya.bean;

import java.util.ArrayList;
import java.util.List;

public class TabAreaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TabAreaExample() {
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

        public Criteria andArea_idIsNull() {
            addCriterion("area_id is null");
            return (Criteria) this;
        }

        public Criteria andArea_idIsNotNull() {
            addCriterion("area_id is not null");
            return (Criteria) this;
        }

        public Criteria andArea_idEqualTo(Integer value) {
            addCriterion("area_id =", value, "area_id");
            return (Criteria) this;
        }

        public Criteria andArea_idNotEqualTo(Integer value) {
            addCriterion("area_id <>", value, "area_id");
            return (Criteria) this;
        }

        public Criteria andArea_idGreaterThan(Integer value) {
            addCriterion("area_id >", value, "area_id");
            return (Criteria) this;
        }

        public Criteria andArea_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("area_id >=", value, "area_id");
            return (Criteria) this;
        }

        public Criteria andArea_idLessThan(Integer value) {
            addCriterion("area_id <", value, "area_id");
            return (Criteria) this;
        }

        public Criteria andArea_idLessThanOrEqualTo(Integer value) {
            addCriterion("area_id <=", value, "area_id");
            return (Criteria) this;
        }

        public Criteria andArea_idIn(List<Integer> values) {
            addCriterion("area_id in", values, "area_id");
            return (Criteria) this;
        }

        public Criteria andArea_idNotIn(List<Integer> values) {
            addCriterion("area_id not in", values, "area_id");
            return (Criteria) this;
        }

        public Criteria andArea_idBetween(Integer value1, Integer value2) {
            addCriterion("area_id between", value1, value2, "area_id");
            return (Criteria) this;
        }

        public Criteria andArea_idNotBetween(Integer value1, Integer value2) {
            addCriterion("area_id not between", value1, value2, "area_id");
            return (Criteria) this;
        }

        public Criteria andArea_nameIsNull() {
            addCriterion("area_name is null");
            return (Criteria) this;
        }

        public Criteria andArea_nameIsNotNull() {
            addCriterion("area_name is not null");
            return (Criteria) this;
        }

        public Criteria andArea_nameEqualTo(String value) {
            addCriterion("area_name =", value, "area_name");
            return (Criteria) this;
        }

        public Criteria andArea_nameNotEqualTo(String value) {
            addCriterion("area_name <>", value, "area_name");
            return (Criteria) this;
        }

        public Criteria andArea_nameGreaterThan(String value) {
            addCriterion("area_name >", value, "area_name");
            return (Criteria) this;
        }

        public Criteria andArea_nameGreaterThanOrEqualTo(String value) {
            addCriterion("area_name >=", value, "area_name");
            return (Criteria) this;
        }

        public Criteria andArea_nameLessThan(String value) {
            addCriterion("area_name <", value, "area_name");
            return (Criteria) this;
        }

        public Criteria andArea_nameLessThanOrEqualTo(String value) {
            addCriterion("area_name <=", value, "area_name");
            return (Criteria) this;
        }

        public Criteria andArea_nameLike(String value) {
            addCriterion("area_name like", value, "area_name");
            return (Criteria) this;
        }

        public Criteria andArea_nameNotLike(String value) {
            addCriterion("area_name not like", value, "area_name");
            return (Criteria) this;
        }

        public Criteria andArea_nameIn(List<String> values) {
            addCriterion("area_name in", values, "area_name");
            return (Criteria) this;
        }

        public Criteria andArea_nameNotIn(List<String> values) {
            addCriterion("area_name not in", values, "area_name");
            return (Criteria) this;
        }

        public Criteria andArea_nameBetween(String value1, String value2) {
            addCriterion("area_name between", value1, value2, "area_name");
            return (Criteria) this;
        }

        public Criteria andArea_nameNotBetween(String value1, String value2) {
            addCriterion("area_name not between", value1, value2, "area_name");
            return (Criteria) this;
        }

        public Criteria andArea_parent_idIsNull() {
            addCriterion("area_parent_id is null");
            return (Criteria) this;
        }

        public Criteria andArea_parent_idIsNotNull() {
            addCriterion("area_parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andArea_parent_idEqualTo(Integer value) {
            addCriterion("area_parent_id =", value, "area_parent_id");
            return (Criteria) this;
        }

        public Criteria andArea_parent_idNotEqualTo(Integer value) {
            addCriterion("area_parent_id <>", value, "area_parent_id");
            return (Criteria) this;
        }

        public Criteria andArea_parent_idGreaterThan(Integer value) {
            addCriterion("area_parent_id >", value, "area_parent_id");
            return (Criteria) this;
        }

        public Criteria andArea_parent_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("area_parent_id >=", value, "area_parent_id");
            return (Criteria) this;
        }

        public Criteria andArea_parent_idLessThan(Integer value) {
            addCriterion("area_parent_id <", value, "area_parent_id");
            return (Criteria) this;
        }

        public Criteria andArea_parent_idLessThanOrEqualTo(Integer value) {
            addCriterion("area_parent_id <=", value, "area_parent_id");
            return (Criteria) this;
        }

        public Criteria andArea_parent_idIn(List<Integer> values) {
            addCriterion("area_parent_id in", values, "area_parent_id");
            return (Criteria) this;
        }

        public Criteria andArea_parent_idNotIn(List<Integer> values) {
            addCriterion("area_parent_id not in", values, "area_parent_id");
            return (Criteria) this;
        }

        public Criteria andArea_parent_idBetween(Integer value1, Integer value2) {
            addCriterion("area_parent_id between", value1, value2, "area_parent_id");
            return (Criteria) this;
        }

        public Criteria andArea_parent_idNotBetween(Integer value1, Integer value2) {
            addCriterion("area_parent_id not between", value1, value2, "area_parent_id");
            return (Criteria) this;
        }

        public Criteria andArea_sortIsNull() {
            addCriterion("area_sort is null");
            return (Criteria) this;
        }

        public Criteria andArea_sortIsNotNull() {
            addCriterion("area_sort is not null");
            return (Criteria) this;
        }

        public Criteria andArea_sortEqualTo(Byte value) {
            addCriterion("area_sort =", value, "area_sort");
            return (Criteria) this;
        }

        public Criteria andArea_sortNotEqualTo(Byte value) {
            addCriterion("area_sort <>", value, "area_sort");
            return (Criteria) this;
        }

        public Criteria andArea_sortGreaterThan(Byte value) {
            addCriterion("area_sort >", value, "area_sort");
            return (Criteria) this;
        }

        public Criteria andArea_sortGreaterThanOrEqualTo(Byte value) {
            addCriterion("area_sort >=", value, "area_sort");
            return (Criteria) this;
        }

        public Criteria andArea_sortLessThan(Byte value) {
            addCriterion("area_sort <", value, "area_sort");
            return (Criteria) this;
        }

        public Criteria andArea_sortLessThanOrEqualTo(Byte value) {
            addCriterion("area_sort <=", value, "area_sort");
            return (Criteria) this;
        }

        public Criteria andArea_sortIn(List<Byte> values) {
            addCriterion("area_sort in", values, "area_sort");
            return (Criteria) this;
        }

        public Criteria andArea_sortNotIn(List<Byte> values) {
            addCriterion("area_sort not in", values, "area_sort");
            return (Criteria) this;
        }

        public Criteria andArea_sortBetween(Byte value1, Byte value2) {
            addCriterion("area_sort between", value1, value2, "area_sort");
            return (Criteria) this;
        }

        public Criteria andArea_sortNotBetween(Byte value1, Byte value2) {
            addCriterion("area_sort not between", value1, value2, "area_sort");
            return (Criteria) this;
        }

        public Criteria andArea_deepIsNull() {
            addCriterion("area_deep is null");
            return (Criteria) this;
        }

        public Criteria andArea_deepIsNotNull() {
            addCriterion("area_deep is not null");
            return (Criteria) this;
        }

        public Criteria andArea_deepEqualTo(Boolean value) {
            addCriterion("area_deep =", value, "area_deep");
            return (Criteria) this;
        }

        public Criteria andArea_deepNotEqualTo(Boolean value) {
            addCriterion("area_deep <>", value, "area_deep");
            return (Criteria) this;
        }

        public Criteria andArea_deepGreaterThan(Boolean value) {
            addCriterion("area_deep >", value, "area_deep");
            return (Criteria) this;
        }

        public Criteria andArea_deepGreaterThanOrEqualTo(Boolean value) {
            addCriterion("area_deep >=", value, "area_deep");
            return (Criteria) this;
        }

        public Criteria andArea_deepLessThan(Boolean value) {
            addCriterion("area_deep <", value, "area_deep");
            return (Criteria) this;
        }

        public Criteria andArea_deepLessThanOrEqualTo(Boolean value) {
            addCriterion("area_deep <=", value, "area_deep");
            return (Criteria) this;
        }

        public Criteria andArea_deepIn(List<Boolean> values) {
            addCriterion("area_deep in", values, "area_deep");
            return (Criteria) this;
        }

        public Criteria andArea_deepNotIn(List<Boolean> values) {
            addCriterion("area_deep not in", values, "area_deep");
            return (Criteria) this;
        }

        public Criteria andArea_deepBetween(Boolean value1, Boolean value2) {
            addCriterion("area_deep between", value1, value2, "area_deep");
            return (Criteria) this;
        }

        public Criteria andArea_deepNotBetween(Boolean value1, Boolean value2) {
            addCriterion("area_deep not between", value1, value2, "area_deep");
            return (Criteria) this;
        }

        public Criteria andTesu_deletedIsNull() {
            addCriterion("tesu_deleted is null");
            return (Criteria) this;
        }

        public Criteria andTesu_deletedIsNotNull() {
            addCriterion("tesu_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andTesu_deletedEqualTo(Boolean value) {
            addCriterion("tesu_deleted =", value, "tesu_deleted");
            return (Criteria) this;
        }

        public Criteria andTesu_deletedNotEqualTo(Boolean value) {
            addCriterion("tesu_deleted <>", value, "tesu_deleted");
            return (Criteria) this;
        }

        public Criteria andTesu_deletedGreaterThan(Boolean value) {
            addCriterion("tesu_deleted >", value, "tesu_deleted");
            return (Criteria) this;
        }

        public Criteria andTesu_deletedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("tesu_deleted >=", value, "tesu_deleted");
            return (Criteria) this;
        }

        public Criteria andTesu_deletedLessThan(Boolean value) {
            addCriterion("tesu_deleted <", value, "tesu_deleted");
            return (Criteria) this;
        }

        public Criteria andTesu_deletedLessThanOrEqualTo(Boolean value) {
            addCriterion("tesu_deleted <=", value, "tesu_deleted");
            return (Criteria) this;
        }

        public Criteria andTesu_deletedIn(List<Boolean> values) {
            addCriterion("tesu_deleted in", values, "tesu_deleted");
            return (Criteria) this;
        }

        public Criteria andTesu_deletedNotIn(List<Boolean> values) {
            addCriterion("tesu_deleted not in", values, "tesu_deleted");
            return (Criteria) this;
        }

        public Criteria andTesu_deletedBetween(Boolean value1, Boolean value2) {
            addCriterion("tesu_deleted between", value1, value2, "tesu_deleted");
            return (Criteria) this;
        }

        public Criteria andTesu_deletedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("tesu_deleted not between", value1, value2, "tesu_deleted");
            return (Criteria) this;
        }

        public Criteria andTesu_descriptionIsNull() {
            addCriterion("tesu_description is null");
            return (Criteria) this;
        }

        public Criteria andTesu_descriptionIsNotNull() {
            addCriterion("tesu_description is not null");
            return (Criteria) this;
        }

        public Criteria andTesu_descriptionEqualTo(String value) {
            addCriterion("tesu_description =", value, "tesu_description");
            return (Criteria) this;
        }

        public Criteria andTesu_descriptionNotEqualTo(String value) {
            addCriterion("tesu_description <>", value, "tesu_description");
            return (Criteria) this;
        }

        public Criteria andTesu_descriptionGreaterThan(String value) {
            addCriterion("tesu_description >", value, "tesu_description");
            return (Criteria) this;
        }

        public Criteria andTesu_descriptionGreaterThanOrEqualTo(String value) {
            addCriterion("tesu_description >=", value, "tesu_description");
            return (Criteria) this;
        }

        public Criteria andTesu_descriptionLessThan(String value) {
            addCriterion("tesu_description <", value, "tesu_description");
            return (Criteria) this;
        }

        public Criteria andTesu_descriptionLessThanOrEqualTo(String value) {
            addCriterion("tesu_description <=", value, "tesu_description");
            return (Criteria) this;
        }

        public Criteria andTesu_descriptionLike(String value) {
            addCriterion("tesu_description like", value, "tesu_description");
            return (Criteria) this;
        }

        public Criteria andTesu_descriptionNotLike(String value) {
            addCriterion("tesu_description not like", value, "tesu_description");
            return (Criteria) this;
        }

        public Criteria andTesu_descriptionIn(List<String> values) {
            addCriterion("tesu_description in", values, "tesu_description");
            return (Criteria) this;
        }

        public Criteria andTesu_descriptionNotIn(List<String> values) {
            addCriterion("tesu_description not in", values, "tesu_description");
            return (Criteria) this;
        }

        public Criteria andTesu_descriptionBetween(String value1, String value2) {
            addCriterion("tesu_description between", value1, value2, "tesu_description");
            return (Criteria) this;
        }

        public Criteria andTesu_descriptionNotBetween(String value1, String value2) {
            addCriterion("tesu_description not between", value1, value2, "tesu_description");
            return (Criteria) this;
        }

        public Criteria andTesu_createdIsNull() {
            addCriterion("tesu_created is null");
            return (Criteria) this;
        }

        public Criteria andTesu_createdIsNotNull() {
            addCriterion("tesu_created is not null");
            return (Criteria) this;
        }

        public Criteria andTesu_createdEqualTo(Integer value) {
            addCriterion("tesu_created =", value, "tesu_created");
            return (Criteria) this;
        }

        public Criteria andTesu_createdNotEqualTo(Integer value) {
            addCriterion("tesu_created <>", value, "tesu_created");
            return (Criteria) this;
        }

        public Criteria andTesu_createdGreaterThan(Integer value) {
            addCriterion("tesu_created >", value, "tesu_created");
            return (Criteria) this;
        }

        public Criteria andTesu_createdGreaterThanOrEqualTo(Integer value) {
            addCriterion("tesu_created >=", value, "tesu_created");
            return (Criteria) this;
        }

        public Criteria andTesu_createdLessThan(Integer value) {
            addCriterion("tesu_created <", value, "tesu_created");
            return (Criteria) this;
        }

        public Criteria andTesu_createdLessThanOrEqualTo(Integer value) {
            addCriterion("tesu_created <=", value, "tesu_created");
            return (Criteria) this;
        }

        public Criteria andTesu_createdIn(List<Integer> values) {
            addCriterion("tesu_created in", values, "tesu_created");
            return (Criteria) this;
        }

        public Criteria andTesu_createdNotIn(List<Integer> values) {
            addCriterion("tesu_created not in", values, "tesu_created");
            return (Criteria) this;
        }

        public Criteria andTesu_createdBetween(Integer value1, Integer value2) {
            addCriterion("tesu_created between", value1, value2, "tesu_created");
            return (Criteria) this;
        }

        public Criteria andTesu_createdNotBetween(Integer value1, Integer value2) {
            addCriterion("tesu_created not between", value1, value2, "tesu_created");
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