package com.weweibuy.brms.model.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RuleConditionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RuleConditionExample() {
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

    public RuleConditionExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public RuleConditionExample orderBy(String ... orderByClauses) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < orderByClauses.length; i++) {
            sb.append(orderByClauses[i]);
            if (i < orderByClauses.length - 1) {
                sb.append(" , ");
            }
        }
        this.setOrderByClause(sb.toString());
        return this;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria(this);
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static Criteria newAndCreateCriteria() {
        RuleConditionExample example = new RuleConditionExample();
        return example.createCriteria();
    }

    public RuleConditionExample when(boolean condition, IExampleWhen then) {
        if (condition) {
            then.example(this);
        }
        return this;
    }

    public RuleConditionExample when(boolean condition, IExampleWhen then, IExampleWhen otherwise) {
        if (condition) {
            then.example(this);
        } else {
            otherwise.example(this);
        }
        return this;
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRuleKeyIsNull() {
            addCriterion("rule_key is null");
            return (Criteria) this;
        }

        public Criteria andRuleKeyIsNotNull() {
            addCriterion("rule_key is not null");
            return (Criteria) this;
        }

        public Criteria andRuleKeyEqualTo(String value) {
            addCriterion("rule_key =", value, "ruleKey");
            return (Criteria) this;
        }

        public Criteria andRuleKeyNotEqualTo(String value) {
            addCriterion("rule_key <>", value, "ruleKey");
            return (Criteria) this;
        }

        public Criteria andRuleKeyGreaterThan(String value) {
            addCriterion("rule_key >", value, "ruleKey");
            return (Criteria) this;
        }

        public Criteria andRuleKeyGreaterThanOrEqualTo(String value) {
            addCriterion("rule_key >=", value, "ruleKey");
            return (Criteria) this;
        }

        public Criteria andRuleKeyLessThan(String value) {
            addCriterion("rule_key <", value, "ruleKey");
            return (Criteria) this;
        }

        public Criteria andRuleKeyLessThanOrEqualTo(String value) {
            addCriterion("rule_key <=", value, "ruleKey");
            return (Criteria) this;
        }

        public Criteria andRuleKeyLike(String value) {
            addCriterion("rule_key like", value, "ruleKey");
            return (Criteria) this;
        }

        public Criteria andRuleKeyNotLike(String value) {
            addCriterion("rule_key not like", value, "ruleKey");
            return (Criteria) this;
        }

        public Criteria andRuleKeyIn(List<String> values) {
            addCriterion("rule_key in", values, "ruleKey");
            return (Criteria) this;
        }

        public Criteria andRuleKeyNotIn(List<String> values) {
            addCriterion("rule_key not in", values, "ruleKey");
            return (Criteria) this;
        }

        public Criteria andRuleKeyBetween(String value1, String value2) {
            addCriterion("rule_key between", value1, value2, "ruleKey");
            return (Criteria) this;
        }

        public Criteria andRuleKeyNotBetween(String value1, String value2) {
            addCriterion("rule_key not between", value1, value2, "ruleKey");
            return (Criteria) this;
        }

        public Criteria andAttrNameIsNull() {
            addCriterion("attr_name is null");
            return (Criteria) this;
        }

        public Criteria andAttrNameIsNotNull() {
            addCriterion("attr_name is not null");
            return (Criteria) this;
        }

        public Criteria andAttrNameEqualTo(String value) {
            addCriterion("attr_name =", value, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrNameNotEqualTo(String value) {
            addCriterion("attr_name <>", value, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrNameGreaterThan(String value) {
            addCriterion("attr_name >", value, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrNameGreaterThanOrEqualTo(String value) {
            addCriterion("attr_name >=", value, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrNameLessThan(String value) {
            addCriterion("attr_name <", value, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrNameLessThanOrEqualTo(String value) {
            addCriterion("attr_name <=", value, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrNameLike(String value) {
            addCriterion("attr_name like", value, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrNameNotLike(String value) {
            addCriterion("attr_name not like", value, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrNameIn(List<String> values) {
            addCriterion("attr_name in", values, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrNameNotIn(List<String> values) {
            addCriterion("attr_name not in", values, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrNameBetween(String value1, String value2) {
            addCriterion("attr_name between", value1, value2, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrNameNotBetween(String value1, String value2) {
            addCriterion("attr_name not between", value1, value2, "attrName");
            return (Criteria) this;
        }

        public Criteria andConditionOperatorIsNull() {
            addCriterion("condition_operator is null");
            return (Criteria) this;
        }

        public Criteria andConditionOperatorIsNotNull() {
            addCriterion("condition_operator is not null");
            return (Criteria) this;
        }

        public Criteria andConditionOperatorEqualTo(String value) {
            addCriterion("condition_operator =", value, "conditionOperator");
            return (Criteria) this;
        }

        public Criteria andConditionOperatorNotEqualTo(String value) {
            addCriterion("condition_operator <>", value, "conditionOperator");
            return (Criteria) this;
        }

        public Criteria andConditionOperatorGreaterThan(String value) {
            addCriterion("condition_operator >", value, "conditionOperator");
            return (Criteria) this;
        }

        public Criteria andConditionOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("condition_operator >=", value, "conditionOperator");
            return (Criteria) this;
        }

        public Criteria andConditionOperatorLessThan(String value) {
            addCriterion("condition_operator <", value, "conditionOperator");
            return (Criteria) this;
        }

        public Criteria andConditionOperatorLessThanOrEqualTo(String value) {
            addCriterion("condition_operator <=", value, "conditionOperator");
            return (Criteria) this;
        }

        public Criteria andConditionOperatorLike(String value) {
            addCriterion("condition_operator like", value, "conditionOperator");
            return (Criteria) this;
        }

        public Criteria andConditionOperatorNotLike(String value) {
            addCriterion("condition_operator not like", value, "conditionOperator");
            return (Criteria) this;
        }

        public Criteria andConditionOperatorIn(List<String> values) {
            addCriterion("condition_operator in", values, "conditionOperator");
            return (Criteria) this;
        }

        public Criteria andConditionOperatorNotIn(List<String> values) {
            addCriterion("condition_operator not in", values, "conditionOperator");
            return (Criteria) this;
        }

        public Criteria andConditionOperatorBetween(String value1, String value2) {
            addCriterion("condition_operator between", value1, value2, "conditionOperator");
            return (Criteria) this;
        }

        public Criteria andConditionOperatorNotBetween(String value1, String value2) {
            addCriterion("condition_operator not between", value1, value2, "conditionOperator");
            return (Criteria) this;
        }

        public Criteria andConditionValueIsNull() {
            addCriterion("condition_value is null");
            return (Criteria) this;
        }

        public Criteria andConditionValueIsNotNull() {
            addCriterion("condition_value is not null");
            return (Criteria) this;
        }

        public Criteria andConditionValueEqualTo(String value) {
            addCriterion("condition_value =", value, "conditionValue");
            return (Criteria) this;
        }

        public Criteria andConditionValueNotEqualTo(String value) {
            addCriterion("condition_value <>", value, "conditionValue");
            return (Criteria) this;
        }

        public Criteria andConditionValueGreaterThan(String value) {
            addCriterion("condition_value >", value, "conditionValue");
            return (Criteria) this;
        }

        public Criteria andConditionValueGreaterThanOrEqualTo(String value) {
            addCriterion("condition_value >=", value, "conditionValue");
            return (Criteria) this;
        }

        public Criteria andConditionValueLessThan(String value) {
            addCriterion("condition_value <", value, "conditionValue");
            return (Criteria) this;
        }

        public Criteria andConditionValueLessThanOrEqualTo(String value) {
            addCriterion("condition_value <=", value, "conditionValue");
            return (Criteria) this;
        }

        public Criteria andConditionValueLike(String value) {
            addCriterion("condition_value like", value, "conditionValue");
            return (Criteria) this;
        }

        public Criteria andConditionValueNotLike(String value) {
            addCriterion("condition_value not like", value, "conditionValue");
            return (Criteria) this;
        }

        public Criteria andConditionValueIn(List<String> values) {
            addCriterion("condition_value in", values, "conditionValue");
            return (Criteria) this;
        }

        public Criteria andConditionValueNotIn(List<String> values) {
            addCriterion("condition_value not in", values, "conditionValue");
            return (Criteria) this;
        }

        public Criteria andConditionValueBetween(String value1, String value2) {
            addCriterion("condition_value between", value1, value2, "conditionValue");
            return (Criteria) this;
        }

        public Criteria andConditionValueNotBetween(String value1, String value2) {
            addCriterion("condition_value not between", value1, value2, "conditionValue");
            return (Criteria) this;
        }

        public Criteria andLogicalOperatorIsNull() {
            addCriterion("logical_operator is null");
            return (Criteria) this;
        }

        public Criteria andLogicalOperatorIsNotNull() {
            addCriterion("logical_operator is not null");
            return (Criteria) this;
        }

        public Criteria andLogicalOperatorEqualTo(String value) {
            addCriterion("logical_operator =", value, "logicalOperator");
            return (Criteria) this;
        }

        public Criteria andLogicalOperatorNotEqualTo(String value) {
            addCriterion("logical_operator <>", value, "logicalOperator");
            return (Criteria) this;
        }

        public Criteria andLogicalOperatorGreaterThan(String value) {
            addCriterion("logical_operator >", value, "logicalOperator");
            return (Criteria) this;
        }

        public Criteria andLogicalOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("logical_operator >=", value, "logicalOperator");
            return (Criteria) this;
        }

        public Criteria andLogicalOperatorLessThan(String value) {
            addCriterion("logical_operator <", value, "logicalOperator");
            return (Criteria) this;
        }

        public Criteria andLogicalOperatorLessThanOrEqualTo(String value) {
            addCriterion("logical_operator <=", value, "logicalOperator");
            return (Criteria) this;
        }

        public Criteria andLogicalOperatorLike(String value) {
            addCriterion("logical_operator like", value, "logicalOperator");
            return (Criteria) this;
        }

        public Criteria andLogicalOperatorNotLike(String value) {
            addCriterion("logical_operator not like", value, "logicalOperator");
            return (Criteria) this;
        }

        public Criteria andLogicalOperatorIn(List<String> values) {
            addCriterion("logical_operator in", values, "logicalOperator");
            return (Criteria) this;
        }

        public Criteria andLogicalOperatorNotIn(List<String> values) {
            addCriterion("logical_operator not in", values, "logicalOperator");
            return (Criteria) this;
        }

        public Criteria andLogicalOperatorBetween(String value1, String value2) {
            addCriterion("logical_operator between", value1, value2, "logicalOperator");
            return (Criteria) this;
        }

        public Criteria andLogicalOperatorNotBetween(String value1, String value2) {
            addCriterion("logical_operator not between", value1, value2, "logicalOperator");
            return (Criteria) this;
        }

        public Criteria andConditionOrderIsNull() {
            addCriterion("condition_order is null");
            return (Criteria) this;
        }

        public Criteria andConditionOrderIsNotNull() {
            addCriterion("condition_order is not null");
            return (Criteria) this;
        }

        public Criteria andConditionOrderEqualTo(Integer value) {
            addCriterion("condition_order =", value, "conditionOrder");
            return (Criteria) this;
        }

        public Criteria andConditionOrderNotEqualTo(Integer value) {
            addCriterion("condition_order <>", value, "conditionOrder");
            return (Criteria) this;
        }

        public Criteria andConditionOrderGreaterThan(Integer value) {
            addCriterion("condition_order >", value, "conditionOrder");
            return (Criteria) this;
        }

        public Criteria andConditionOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("condition_order >=", value, "conditionOrder");
            return (Criteria) this;
        }

        public Criteria andConditionOrderLessThan(Integer value) {
            addCriterion("condition_order <", value, "conditionOrder");
            return (Criteria) this;
        }

        public Criteria andConditionOrderLessThanOrEqualTo(Integer value) {
            addCriterion("condition_order <=", value, "conditionOrder");
            return (Criteria) this;
        }

        public Criteria andConditionOrderIn(List<Integer> values) {
            addCriterion("condition_order in", values, "conditionOrder");
            return (Criteria) this;
        }

        public Criteria andConditionOrderNotIn(List<Integer> values) {
            addCriterion("condition_order not in", values, "conditionOrder");
            return (Criteria) this;
        }

        public Criteria andConditionOrderBetween(Integer value1, Integer value2) {
            addCriterion("condition_order between", value1, value2, "conditionOrder");
            return (Criteria) this;
        }

        public Criteria andConditionOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("condition_order not between", value1, value2, "conditionOrder");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedEqualTo(Boolean value) {
            addCriterion("is_delete =", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotEqualTo(Boolean value) {
            addCriterion("is_delete <>", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThan(Boolean value) {
            addCriterion("is_delete >", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_delete >=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThan(Boolean value) {
            addCriterion("is_delete <", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThanOrEqualTo(Boolean value) {
            addCriterion("is_delete <=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedIn(List<Boolean> values) {
            addCriterion("is_delete in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotIn(List<Boolean> values) {
            addCriterion("is_delete not in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedBetween(Boolean value1, Boolean value2) {
            addCriterion("is_delete between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_delete not between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(LocalDateTime value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(LocalDateTime value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(LocalDateTime value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(LocalDateTime value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<LocalDateTime> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<LocalDateTime> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(LocalDateTime value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(LocalDateTime value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(LocalDateTime value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(LocalDateTime value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<LocalDateTime> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<LocalDateTime> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        private RuleConditionExample example;

        protected Criteria(RuleConditionExample example) {
            super();
            this.example = example;
        }

        public RuleConditionExample example() {
            return this.example;
        }

        @Deprecated
        public Criteria andIf(boolean ifAdd, ICriteriaAdd add) {
            if (ifAdd) {
                add.add(this);
            }
            return this;
        }

        public Criteria when(boolean condition, ICriteriaWhen then) {
            if (condition) {
                then.criteria(this);
            }
            return this;
        }

        public Criteria when(boolean condition, ICriteriaWhen then, ICriteriaWhen otherwise) {
            if (condition) {
                then.criteria(this);
            } else {
                otherwise.criteria(this);
            }
            return this;
        }

        @Deprecated
        public interface ICriteriaAdd {
            Criteria add(Criteria add);
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

    public interface ICriteriaWhen {
        void criteria(Criteria criteria);
    }

    public interface IExampleWhen {
        void example(com.weweibuy.brms.model.example.RuleConditionExample example);
    }
}