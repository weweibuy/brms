package com.weweibuy.brms.model.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RuleActionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RuleActionExample() {
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

    public RuleActionExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public RuleActionExample orderBy(String ... orderByClauses) {
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
        RuleActionExample example = new RuleActionExample();
        return example.createCriteria();
    }

    public RuleActionExample when(boolean condition, IExampleWhen then) {
        if (condition) {
            then.example(this);
        }
        return this;
    }

    public RuleActionExample when(boolean condition, IExampleWhen then, IExampleWhen otherwise) {
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

        public Criteria andActionValueIsNull() {
            addCriterion("action_value is null");
            return (Criteria) this;
        }

        public Criteria andActionValueIsNotNull() {
            addCriterion("action_value is not null");
            return (Criteria) this;
        }

        public Criteria andActionValueEqualTo(String value) {
            addCriterion("action_value =", value, "actionValue");
            return (Criteria) this;
        }

        public Criteria andActionValueNotEqualTo(String value) {
            addCriterion("action_value <>", value, "actionValue");
            return (Criteria) this;
        }

        public Criteria andActionValueGreaterThan(String value) {
            addCriterion("action_value >", value, "actionValue");
            return (Criteria) this;
        }

        public Criteria andActionValueGreaterThanOrEqualTo(String value) {
            addCriterion("action_value >=", value, "actionValue");
            return (Criteria) this;
        }

        public Criteria andActionValueLessThan(String value) {
            addCriterion("action_value <", value, "actionValue");
            return (Criteria) this;
        }

        public Criteria andActionValueLessThanOrEqualTo(String value) {
            addCriterion("action_value <=", value, "actionValue");
            return (Criteria) this;
        }

        public Criteria andActionValueLike(String value) {
            addCriterion("action_value like", value, "actionValue");
            return (Criteria) this;
        }

        public Criteria andActionValueNotLike(String value) {
            addCriterion("action_value not like", value, "actionValue");
            return (Criteria) this;
        }

        public Criteria andActionValueIn(List<String> values) {
            addCriterion("action_value in", values, "actionValue");
            return (Criteria) this;
        }

        public Criteria andActionValueNotIn(List<String> values) {
            addCriterion("action_value not in", values, "actionValue");
            return (Criteria) this;
        }

        public Criteria andActionValueBetween(String value1, String value2) {
            addCriterion("action_value between", value1, value2, "actionValue");
            return (Criteria) this;
        }

        public Criteria andActionValueNotBetween(String value1, String value2) {
            addCriterion("action_value not between", value1, value2, "actionValue");
            return (Criteria) this;
        }

        public Criteria andActionValueTypeIsNull() {
            addCriterion("action_value_type is null");
            return (Criteria) this;
        }

        public Criteria andActionValueTypeIsNotNull() {
            addCriterion("action_value_type is not null");
            return (Criteria) this;
        }

        public Criteria andActionValueTypeEqualTo(String value) {
            addCriterion("action_value_type =", value, "actionValueType");
            return (Criteria) this;
        }

        public Criteria andActionValueTypeNotEqualTo(String value) {
            addCriterion("action_value_type <>", value, "actionValueType");
            return (Criteria) this;
        }

        public Criteria andActionValueTypeGreaterThan(String value) {
            addCriterion("action_value_type >", value, "actionValueType");
            return (Criteria) this;
        }

        public Criteria andActionValueTypeGreaterThanOrEqualTo(String value) {
            addCriterion("action_value_type >=", value, "actionValueType");
            return (Criteria) this;
        }

        public Criteria andActionValueTypeLessThan(String value) {
            addCriterion("action_value_type <", value, "actionValueType");
            return (Criteria) this;
        }

        public Criteria andActionValueTypeLessThanOrEqualTo(String value) {
            addCriterion("action_value_type <=", value, "actionValueType");
            return (Criteria) this;
        }

        public Criteria andActionValueTypeLike(String value) {
            addCriterion("action_value_type like", value, "actionValueType");
            return (Criteria) this;
        }

        public Criteria andActionValueTypeNotLike(String value) {
            addCriterion("action_value_type not like", value, "actionValueType");
            return (Criteria) this;
        }

        public Criteria andActionValueTypeIn(List<String> values) {
            addCriterion("action_value_type in", values, "actionValueType");
            return (Criteria) this;
        }

        public Criteria andActionValueTypeNotIn(List<String> values) {
            addCriterion("action_value_type not in", values, "actionValueType");
            return (Criteria) this;
        }

        public Criteria andActionValueTypeBetween(String value1, String value2) {
            addCriterion("action_value_type between", value1, value2, "actionValueType");
            return (Criteria) this;
        }

        public Criteria andActionValueTypeNotBetween(String value1, String value2) {
            addCriterion("action_value_type not between", value1, value2, "actionValueType");
            return (Criteria) this;
        }

        public Criteria andValueCalculateFormulaIsNull() {
            addCriterion("value_calculate_formula is null");
            return (Criteria) this;
        }

        public Criteria andValueCalculateFormulaIsNotNull() {
            addCriterion("value_calculate_formula is not null");
            return (Criteria) this;
        }

        public Criteria andValueCalculateFormulaEqualTo(String value) {
            addCriterion("value_calculate_formula =", value, "valueCalculateFormula");
            return (Criteria) this;
        }

        public Criteria andValueCalculateFormulaNotEqualTo(String value) {
            addCriterion("value_calculate_formula <>", value, "valueCalculateFormula");
            return (Criteria) this;
        }

        public Criteria andValueCalculateFormulaGreaterThan(String value) {
            addCriterion("value_calculate_formula >", value, "valueCalculateFormula");
            return (Criteria) this;
        }

        public Criteria andValueCalculateFormulaGreaterThanOrEqualTo(String value) {
            addCriterion("value_calculate_formula >=", value, "valueCalculateFormula");
            return (Criteria) this;
        }

        public Criteria andValueCalculateFormulaLessThan(String value) {
            addCriterion("value_calculate_formula <", value, "valueCalculateFormula");
            return (Criteria) this;
        }

        public Criteria andValueCalculateFormulaLessThanOrEqualTo(String value) {
            addCriterion("value_calculate_formula <=", value, "valueCalculateFormula");
            return (Criteria) this;
        }

        public Criteria andValueCalculateFormulaLike(String value) {
            addCriterion("value_calculate_formula like", value, "valueCalculateFormula");
            return (Criteria) this;
        }

        public Criteria andValueCalculateFormulaNotLike(String value) {
            addCriterion("value_calculate_formula not like", value, "valueCalculateFormula");
            return (Criteria) this;
        }

        public Criteria andValueCalculateFormulaIn(List<String> values) {
            addCriterion("value_calculate_formula in", values, "valueCalculateFormula");
            return (Criteria) this;
        }

        public Criteria andValueCalculateFormulaNotIn(List<String> values) {
            addCriterion("value_calculate_formula not in", values, "valueCalculateFormula");
            return (Criteria) this;
        }

        public Criteria andValueCalculateFormulaBetween(String value1, String value2) {
            addCriterion("value_calculate_formula between", value1, value2, "valueCalculateFormula");
            return (Criteria) this;
        }

        public Criteria andValueCalculateFormulaNotBetween(String value1, String value2) {
            addCriterion("value_calculate_formula not between", value1, value2, "valueCalculateFormula");
            return (Criteria) this;
        }

        public Criteria andCalculateScaleIsNull() {
            addCriterion("calculate_scale is null");
            return (Criteria) this;
        }

        public Criteria andCalculateScaleIsNotNull() {
            addCriterion("calculate_scale is not null");
            return (Criteria) this;
        }

        public Criteria andCalculateScaleEqualTo(Integer value) {
            addCriterion("calculate_scale =", value, "calculateScale");
            return (Criteria) this;
        }

        public Criteria andCalculateScaleNotEqualTo(Integer value) {
            addCriterion("calculate_scale <>", value, "calculateScale");
            return (Criteria) this;
        }

        public Criteria andCalculateScaleGreaterThan(Integer value) {
            addCriterion("calculate_scale >", value, "calculateScale");
            return (Criteria) this;
        }

        public Criteria andCalculateScaleGreaterThanOrEqualTo(Integer value) {
            addCriterion("calculate_scale >=", value, "calculateScale");
            return (Criteria) this;
        }

        public Criteria andCalculateScaleLessThan(Integer value) {
            addCriterion("calculate_scale <", value, "calculateScale");
            return (Criteria) this;
        }

        public Criteria andCalculateScaleLessThanOrEqualTo(Integer value) {
            addCriterion("calculate_scale <=", value, "calculateScale");
            return (Criteria) this;
        }

        public Criteria andCalculateScaleIn(List<Integer> values) {
            addCriterion("calculate_scale in", values, "calculateScale");
            return (Criteria) this;
        }

        public Criteria andCalculateScaleNotIn(List<Integer> values) {
            addCriterion("calculate_scale not in", values, "calculateScale");
            return (Criteria) this;
        }

        public Criteria andCalculateScaleBetween(Integer value1, Integer value2) {
            addCriterion("calculate_scale between", value1, value2, "calculateScale");
            return (Criteria) this;
        }

        public Criteria andCalculateScaleNotBetween(Integer value1, Integer value2) {
            addCriterion("calculate_scale not between", value1, value2, "calculateScale");
            return (Criteria) this;
        }

        public Criteria andCalculateRoundingModeIsNull() {
            addCriterion("calculate_rounding_mode is null");
            return (Criteria) this;
        }

        public Criteria andCalculateRoundingModeIsNotNull() {
            addCriterion("calculate_rounding_mode is not null");
            return (Criteria) this;
        }

        public Criteria andCalculateRoundingModeEqualTo(String value) {
            addCriterion("calculate_rounding_mode =", value, "calculateRoundingMode");
            return (Criteria) this;
        }

        public Criteria andCalculateRoundingModeNotEqualTo(String value) {
            addCriterion("calculate_rounding_mode <>", value, "calculateRoundingMode");
            return (Criteria) this;
        }

        public Criteria andCalculateRoundingModeGreaterThan(String value) {
            addCriterion("calculate_rounding_mode >", value, "calculateRoundingMode");
            return (Criteria) this;
        }

        public Criteria andCalculateRoundingModeGreaterThanOrEqualTo(String value) {
            addCriterion("calculate_rounding_mode >=", value, "calculateRoundingMode");
            return (Criteria) this;
        }

        public Criteria andCalculateRoundingModeLessThan(String value) {
            addCriterion("calculate_rounding_mode <", value, "calculateRoundingMode");
            return (Criteria) this;
        }

        public Criteria andCalculateRoundingModeLessThanOrEqualTo(String value) {
            addCriterion("calculate_rounding_mode <=", value, "calculateRoundingMode");
            return (Criteria) this;
        }

        public Criteria andCalculateRoundingModeLike(String value) {
            addCriterion("calculate_rounding_mode like", value, "calculateRoundingMode");
            return (Criteria) this;
        }

        public Criteria andCalculateRoundingModeNotLike(String value) {
            addCriterion("calculate_rounding_mode not like", value, "calculateRoundingMode");
            return (Criteria) this;
        }

        public Criteria andCalculateRoundingModeIn(List<String> values) {
            addCriterion("calculate_rounding_mode in", values, "calculateRoundingMode");
            return (Criteria) this;
        }

        public Criteria andCalculateRoundingModeNotIn(List<String> values) {
            addCriterion("calculate_rounding_mode not in", values, "calculateRoundingMode");
            return (Criteria) this;
        }

        public Criteria andCalculateRoundingModeBetween(String value1, String value2) {
            addCriterion("calculate_rounding_mode between", value1, value2, "calculateRoundingMode");
            return (Criteria) this;
        }

        public Criteria andCalculateRoundingModeNotBetween(String value1, String value2) {
            addCriterion("calculate_rounding_mode not between", value1, value2, "calculateRoundingMode");
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
        private RuleActionExample example;

        protected Criteria(RuleActionExample example) {
            super();
            this.example = example;
        }

        public RuleActionExample example() {
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
        void example(com.weweibuy.brms.model.example.RuleActionExample example);
    }
}