package com.liutf.mvc.entity.mysql;

import java.util.ArrayList;
import java.util.List;

public class TestExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TestExample() {
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

        public Criteria andT1IsNull() {
            addCriterion("t1 is null");
            return (Criteria) this;
        }

        public Criteria andT1IsNotNull() {
            addCriterion("t1 is not null");
            return (Criteria) this;
        }

        public Criteria andT1EqualTo(String value) {
            addCriterion("t1 =", value, "t1");
            return (Criteria) this;
        }

        public Criteria andT1NotEqualTo(String value) {
            addCriterion("t1 <>", value, "t1");
            return (Criteria) this;
        }

        public Criteria andT1GreaterThan(String value) {
            addCriterion("t1 >", value, "t1");
            return (Criteria) this;
        }

        public Criteria andT1GreaterThanOrEqualTo(String value) {
            addCriterion("t1 >=", value, "t1");
            return (Criteria) this;
        }

        public Criteria andT1LessThan(String value) {
            addCriterion("t1 <", value, "t1");
            return (Criteria) this;
        }

        public Criteria andT1LessThanOrEqualTo(String value) {
            addCriterion("t1 <=", value, "t1");
            return (Criteria) this;
        }

        public Criteria andT1Like(String value) {
            addCriterion("t1 like", value, "t1");
            return (Criteria) this;
        }

        public Criteria andT1NotLike(String value) {
            addCriterion("t1 not like", value, "t1");
            return (Criteria) this;
        }

        public Criteria andT1In(List<String> values) {
            addCriterion("t1 in", values, "t1");
            return (Criteria) this;
        }

        public Criteria andT1NotIn(List<String> values) {
            addCriterion("t1 not in", values, "t1");
            return (Criteria) this;
        }

        public Criteria andT1Between(String value1, String value2) {
            addCriterion("t1 between", value1, value2, "t1");
            return (Criteria) this;
        }

        public Criteria andT1NotBetween(String value1, String value2) {
            addCriterion("t1 not between", value1, value2, "t1");
            return (Criteria) this;
        }

        public Criteria andT2IsNull() {
            addCriterion("t2 is null");
            return (Criteria) this;
        }

        public Criteria andT2IsNotNull() {
            addCriterion("t2 is not null");
            return (Criteria) this;
        }

        public Criteria andT2EqualTo(String value) {
            addCriterion("t2 =", value, "t2");
            return (Criteria) this;
        }

        public Criteria andT2NotEqualTo(String value) {
            addCriterion("t2 <>", value, "t2");
            return (Criteria) this;
        }

        public Criteria andT2GreaterThan(String value) {
            addCriterion("t2 >", value, "t2");
            return (Criteria) this;
        }

        public Criteria andT2GreaterThanOrEqualTo(String value) {
            addCriterion("t2 >=", value, "t2");
            return (Criteria) this;
        }

        public Criteria andT2LessThan(String value) {
            addCriterion("t2 <", value, "t2");
            return (Criteria) this;
        }

        public Criteria andT2LessThanOrEqualTo(String value) {
            addCriterion("t2 <=", value, "t2");
            return (Criteria) this;
        }

        public Criteria andT2Like(String value) {
            addCriterion("t2 like", value, "t2");
            return (Criteria) this;
        }

        public Criteria andT2NotLike(String value) {
            addCriterion("t2 not like", value, "t2");
            return (Criteria) this;
        }

        public Criteria andT2In(List<String> values) {
            addCriterion("t2 in", values, "t2");
            return (Criteria) this;
        }

        public Criteria andT2NotIn(List<String> values) {
            addCriterion("t2 not in", values, "t2");
            return (Criteria) this;
        }

        public Criteria andT2Between(String value1, String value2) {
            addCriterion("t2 between", value1, value2, "t2");
            return (Criteria) this;
        }

        public Criteria andT2NotBetween(String value1, String value2) {
            addCriterion("t2 not between", value1, value2, "t2");
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