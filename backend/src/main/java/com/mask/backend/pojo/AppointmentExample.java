package com.mask.backend.pojo;

import java.util.ArrayList;
import java.util.List;

public class AppointmentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppointmentExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMaxxIsNull() {
            addCriterion("maxx is null");
            return (Criteria) this;
        }

        public Criteria andMaxxIsNotNull() {
            addCriterion("maxx is not null");
            return (Criteria) this;
        }

        public Criteria andMaxxEqualTo(Integer value) {
            addCriterion("maxx =", value, "maxx");
            return (Criteria) this;
        }

        public Criteria andMaxxNotEqualTo(Integer value) {
            addCriterion("maxx <>", value, "maxx");
            return (Criteria) this;
        }

        public Criteria andMaxxGreaterThan(Integer value) {
            addCriterion("maxx >", value, "maxx");
            return (Criteria) this;
        }

        public Criteria andMaxxGreaterThanOrEqualTo(Integer value) {
            addCriterion("maxx >=", value, "maxx");
            return (Criteria) this;
        }

        public Criteria andMaxxLessThan(Integer value) {
            addCriterion("maxx <", value, "maxx");
            return (Criteria) this;
        }

        public Criteria andMaxxLessThanOrEqualTo(Integer value) {
            addCriterion("maxx <=", value, "maxx");
            return (Criteria) this;
        }

        public Criteria andMaxxIn(List<Integer> values) {
            addCriterion("maxx in", values, "maxx");
            return (Criteria) this;
        }

        public Criteria andMaxxNotIn(List<Integer> values) {
            addCriterion("maxx not in", values, "maxx");
            return (Criteria) this;
        }

        public Criteria andMaxxBetween(Integer value1, Integer value2) {
            addCriterion("maxx between", value1, value2, "maxx");
            return (Criteria) this;
        }

        public Criteria andMaxxNotBetween(Integer value1, Integer value2) {
            addCriterion("maxx not between", value1, value2, "maxx");
            return (Criteria) this;
        }

        public Criteria andLimittIsNull() {
            addCriterion("limitt is null");
            return (Criteria) this;
        }

        public Criteria andLimittIsNotNull() {
            addCriterion("limitt is not null");
            return (Criteria) this;
        }

        public Criteria andLimittEqualTo(Integer value) {
            addCriterion("limitt =", value, "limitt");
            return (Criteria) this;
        }

        public Criteria andLimittNotEqualTo(Integer value) {
            addCriterion("limitt <>", value, "limitt");
            return (Criteria) this;
        }

        public Criteria andLimittGreaterThan(Integer value) {
            addCriterion("limitt >", value, "limitt");
            return (Criteria) this;
        }

        public Criteria andLimittGreaterThanOrEqualTo(Integer value) {
            addCriterion("limitt >=", value, "limitt");
            return (Criteria) this;
        }

        public Criteria andLimittLessThan(Integer value) {
            addCriterion("limitt <", value, "limitt");
            return (Criteria) this;
        }

        public Criteria andLimittLessThanOrEqualTo(Integer value) {
            addCriterion("limitt <=", value, "limitt");
            return (Criteria) this;
        }

        public Criteria andLimittIn(List<Integer> values) {
            addCriterion("limitt in", values, "limitt");
            return (Criteria) this;
        }

        public Criteria andLimittNotIn(List<Integer> values) {
            addCriterion("limitt not in", values, "limitt");
            return (Criteria) this;
        }

        public Criteria andLimittBetween(Integer value1, Integer value2) {
            addCriterion("limitt between", value1, value2, "limitt");
            return (Criteria) this;
        }

        public Criteria andLimittNotBetween(Integer value1, Integer value2) {
            addCriterion("limitt not between", value1, value2, "limitt");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNull() {
            addCriterion("startTime is null");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNotNull() {
            addCriterion("startTime is not null");
            return (Criteria) this;
        }

        public Criteria andStarttimeEqualTo(String value) {
            addCriterion("startTime =", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotEqualTo(String value) {
            addCriterion("startTime <>", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThan(String value) {
            addCriterion("startTime >", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThanOrEqualTo(String value) {
            addCriterion("startTime >=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThan(String value) {
            addCriterion("startTime <", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThanOrEqualTo(String value) {
            addCriterion("startTime <=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLike(String value) {
            addCriterion("startTime like", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotLike(String value) {
            addCriterion("startTime not like", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIn(List<String> values) {
            addCriterion("startTime in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotIn(List<String> values) {
            addCriterion("startTime not in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeBetween(String value1, String value2) {
            addCriterion("startTime between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotBetween(String value1, String value2) {
            addCriterion("startTime not between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("endTime is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("endTime is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(String value) {
            addCriterion("endTime =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(String value) {
            addCriterion("endTime <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(String value) {
            addCriterion("endTime >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(String value) {
            addCriterion("endTime >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(String value) {
            addCriterion("endTime <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(String value) {
            addCriterion("endTime <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLike(String value) {
            addCriterion("endTime like", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotLike(String value) {
            addCriterion("endTime not like", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<String> values) {
            addCriterion("endTime in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<String> values) {
            addCriterion("endTime not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(String value1, String value2) {
            addCriterion("endTime between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(String value1, String value2) {
            addCriterion("endTime not between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andStatussIsNull() {
            addCriterion("statuss is null");
            return (Criteria) this;
        }

        public Criteria andStatussIsNotNull() {
            addCriterion("statuss is not null");
            return (Criteria) this;
        }

        public Criteria andStatussEqualTo(Integer value) {
            addCriterion("statuss =", value, "statuss");
            return (Criteria) this;
        }

        public Criteria andStatussNotEqualTo(Integer value) {
            addCriterion("statuss <>", value, "statuss");
            return (Criteria) this;
        }

        public Criteria andStatussGreaterThan(Integer value) {
            addCriterion("statuss >", value, "statuss");
            return (Criteria) this;
        }

        public Criteria andStatussGreaterThanOrEqualTo(Integer value) {
            addCriterion("statuss >=", value, "statuss");
            return (Criteria) this;
        }

        public Criteria andStatussLessThan(Integer value) {
            addCriterion("statuss <", value, "statuss");
            return (Criteria) this;
        }

        public Criteria andStatussLessThanOrEqualTo(Integer value) {
            addCriterion("statuss <=", value, "statuss");
            return (Criteria) this;
        }

        public Criteria andStatussIn(List<Integer> values) {
            addCriterion("statuss in", values, "statuss");
            return (Criteria) this;
        }

        public Criteria andStatussNotIn(List<Integer> values) {
            addCriterion("statuss not in", values, "statuss");
            return (Criteria) this;
        }

        public Criteria andStatussBetween(Integer value1, Integer value2) {
            addCriterion("statuss between", value1, value2, "statuss");
            return (Criteria) this;
        }

        public Criteria andStatussNotBetween(Integer value1, Integer value2) {
            addCriterion("statuss not between", value1, value2, "statuss");
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