package com.weweibuy.brms.model.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RuleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RuleExample() {
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

    public RuleExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public RuleExample orderBy(String ... orderByClauses) {
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
        RuleExample example = new RuleExample();
        return example.createCriteria();
    }

    public RuleExample when(boolean condition, IExampleWhen then) {
        if (condition) {
            then.example(this);
        }
        return this;
    }

    public RuleExample when(boolean condition, IExampleWhen then, IExampleWhen otherwise) {
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

        public Criteria andRuleDescIsNull() {
            addCriterion("rule_desc is null");
            return (Criteria) this;
        }

        public Criteria andRuleDescIsNotNull() {
            addCriterion("rule_desc is not null");
            return (Criteria) this;
        }

        public Criteria andRuleDescEqualTo(String value) {
            addCriterion("rule_desc =", value, "ruleDesc");
            return (Criteria) this;
        }

        public Criteria andRuleDescNotEqualTo(String value) {
            addCriterion("rule_desc <>", value, "ruleDesc");
            return (Criteria) this;
        }

        public Criteria andRuleDescGreaterThan(String value) {
            addCriterion("rule_desc >", value, "ruleDesc");
            return (Criteria) this;
        }

        public Criteria andRuleDescGreaterThanOrEqualTo(String value) {
            addCriterion("rule_desc >=", value, "ruleDesc");
            return (Criteria) this;
        }

        public Criteria andRuleDescLessThan(String value) {
            addCriterion("rule_desc <", value, "ruleDesc");
            return (Criteria) this;
        }

        public Criteria andRuleDescLessThanOrEqualTo(String value) {
            addCriterion("rule_desc <=", value, "ruleDesc");
            return (Criteria) this;
        }

        public Criteria andRuleDescLike(String value) {
            addCriterion("rule_desc like", value, "ruleDesc");
            return (Criteria) this;
        }

        public Criteria andRuleDescNotLike(String value) {
            addCriterion("rule_desc not like", value, "ruleDesc");
            return (Criteria) this;
        }

        public Criteria andRuleDescIn(List<String> values) {
            addCriterion("rule_desc in", values, "ruleDesc");
            return (Criteria) this;
        }

        public Criteria andRuleDescNotIn(List<String> values) {
            addCriterion("rule_desc not in", values, "ruleDesc");
            return (Criteria) this;
        }

        public Criteria andRuleDescBetween(String value1, String value2) {
            addCriterion("rule_desc between", value1, value2, "ruleDesc");
            return (Criteria) this;
        }

        public Criteria andRuleDescNotBetween(String value1, String value2) {
            addCriterion("rule_desc not between", value1, value2, "ruleDesc");
            return (Criteria) this;
        }

        public Criteria andRuleSetKeyIsNull() {
            addCriterion("rule_set_key is null");
            return (Criteria) this;
        }

        public Criteria andRuleSetKeyIsNotNull() {
            addCriterion("rule_set_key is not null");
            return (Criteria) this;
        }

        public Criteria andRuleSetKeyEqualTo(String value) {
            addCriterion("rule_set_key =", value, "ruleSetKey");
            return (Criteria) this;
        }

        public Criteria andRuleSetKeyNotEqualTo(String value) {
            addCriterion("rule_set_key <>", value, "ruleSetKey");
            return (Criteria) this;
        }

        public Criteria andRuleSetKeyGreaterThan(String value) {
            addCriterion("rule_set_key >", value, "ruleSetKey");
            return (Criteria) this;
        }

        public Criteria andRuleSetKeyGreaterThanOrEqualTo(String value) {
            addCriterion("rule_set_key >=", value, "ruleSetKey");
            return (Criteria) this;
        }

        public Criteria andRuleSetKeyLessThan(String value) {
            addCriterion("rule_set_key <", value, "ruleSetKey");
            return (Criteria) this;
        }

        public Criteria andRuleSetKeyLessThanOrEqualTo(String value) {
            addCriterion("rule_set_key <=", value, "ruleSetKey");
            return (Criteria) this;
        }

        public Criteria andRuleSetKeyLike(String value) {
            addCriterion("rule_set_key like", value, "ruleSetKey");
            return (Criteria) this;
        }

        public Criteria andRuleSetKeyNotLike(String value) {
            addCriterion("rule_set_key not like", value, "ruleSetKey");
            return (Criteria) this;
        }

        public Criteria andRuleSetKeyIn(List<String> values) {
            addCriterion("rule_set_key in", values, "ruleSetKey");
            return (Criteria) this;
        }

        public Criteria andRuleSetKeyNotIn(List<String> values) {
            addCriterion("rule_set_key not in", values, "ruleSetKey");
            return (Criteria) this;
        }

        public Criteria andRuleSetKeyBetween(String value1, String value2) {
            addCriterion("rule_set_key between", value1, value2, "ruleSetKey");
            return (Criteria) this;
        }

        public Criteria andRuleSetKeyNotBetween(String value1, String value2) {
            addCriterion("rule_set_key not between", value1, value2, "ruleSetKey");
            return (Criteria) this;
        }

        public Criteria andRuleEnterTypeIsNull() {
            addCriterion("rule_enter_type is null");
            return (Criteria) this;
        }

        public Criteria andRuleEnterTypeIsNotNull() {
            addCriterion("rule_enter_type is not null");
            return (Criteria) this;
        }

        public Criteria andRuleEnterTypeEqualTo(String value) {
            addCriterion("rule_enter_type =", value, "ruleEnterType");
            return (Criteria) this;
        }

        public Criteria andRuleEnterTypeNotEqualTo(String value) {
            addCriterion("rule_enter_type <>", value, "ruleEnterType");
            return (Criteria) this;
        }

        public Criteria andRuleEnterTypeGreaterThan(String value) {
            addCriterion("rule_enter_type >", value, "ruleEnterType");
            return (Criteria) this;
        }

        public Criteria andRuleEnterTypeGreaterThanOrEqualTo(String value) {
            addCriterion("rule_enter_type >=", value, "ruleEnterType");
            return (Criteria) this;
        }

        public Criteria andRuleEnterTypeLessThan(String value) {
            addCriterion("rule_enter_type <", value, "ruleEnterType");
            return (Criteria) this;
        }

        public Criteria andRuleEnterTypeLessThanOrEqualTo(String value) {
            addCriterion("rule_enter_type <=", value, "ruleEnterType");
            return (Criteria) this;
        }

        public Criteria andRuleEnterTypeLike(String value) {
            addCriterion("rule_enter_type like", value, "ruleEnterType");
            return (Criteria) this;
        }

        public Criteria andRuleEnterTypeNotLike(String value) {
            addCriterion("rule_enter_type not like", value, "ruleEnterType");
            return (Criteria) this;
        }

        public Criteria andRuleEnterTypeIn(List<String> values) {
            addCriterion("rule_enter_type in", values, "ruleEnterType");
            return (Criteria) this;
        }

        public Criteria andRuleEnterTypeNotIn(List<String> values) {
            addCriterion("rule_enter_type not in", values, "ruleEnterType");
            return (Criteria) this;
        }

        public Criteria andRuleEnterTypeBetween(String value1, String value2) {
            addCriterion("rule_enter_type between", value1, value2, "ruleEnterType");
            return (Criteria) this;
        }

        public Criteria andRuleEnterTypeNotBetween(String value1, String value2) {
            addCriterion("rule_enter_type not between", value1, value2, "ruleEnterType");
            return (Criteria) this;
        }

        public Criteria andRuleConditionTextIsNull() {
            addCriterion("rule_condition_text is null");
            return (Criteria) this;
        }

        public Criteria andRuleConditionTextIsNotNull() {
            addCriterion("rule_condition_text is not null");
            return (Criteria) this;
        }

        public Criteria andRuleConditionTextEqualTo(String value) {
            addCriterion("rule_condition_text =", value, "ruleConditionText");
            return (Criteria) this;
        }

        public Criteria andRuleConditionTextNotEqualTo(String value) {
            addCriterion("rule_condition_text <>", value, "ruleConditionText");
            return (Criteria) this;
        }

        public Criteria andRuleConditionTextGreaterThan(String value) {
            addCriterion("rule_condition_text >", value, "ruleConditionText");
            return (Criteria) this;
        }

        public Criteria andRuleConditionTextGreaterThanOrEqualTo(String value) {
            addCriterion("rule_condition_text >=", value, "ruleConditionText");
            return (Criteria) this;
        }

        public Criteria andRuleConditionTextLessThan(String value) {
            addCriterion("rule_condition_text <", value, "ruleConditionText");
            return (Criteria) this;
        }

        public Criteria andRuleConditionTextLessThanOrEqualTo(String value) {
            addCriterion("rule_condition_text <=", value, "ruleConditionText");
            return (Criteria) this;
        }

        public Criteria andRuleConditionTextLike(String value) {
            addCriterion("rule_condition_text like", value, "ruleConditionText");
            return (Criteria) this;
        }

        public Criteria andRuleConditionTextNotLike(String value) {
            addCriterion("rule_condition_text not like", value, "ruleConditionText");
            return (Criteria) this;
        }

        public Criteria andRuleConditionTextIn(List<String> values) {
            addCriterion("rule_condition_text in", values, "ruleConditionText");
            return (Criteria) this;
        }

        public Criteria andRuleConditionTextNotIn(List<String> values) {
            addCriterion("rule_condition_text not in", values, "ruleConditionText");
            return (Criteria) this;
        }

        public Criteria andRuleConditionTextBetween(String value1, String value2) {
            addCriterion("rule_condition_text between", value1, value2, "ruleConditionText");
            return (Criteria) this;
        }

        public Criteria andRuleConditionTextNotBetween(String value1, String value2) {
            addCriterion("rule_condition_text not between", value1, value2, "ruleConditionText");
            return (Criteria) this;
        }

        public Criteria andRuleActionTextIsNull() {
            addCriterion("rule_action_text is null");
            return (Criteria) this;
        }

        public Criteria andRuleActionTextIsNotNull() {
            addCriterion("rule_action_text is not null");
            return (Criteria) this;
        }

        public Criteria andRuleActionTextEqualTo(String value) {
            addCriterion("rule_action_text =", value, "ruleActionText");
            return (Criteria) this;
        }

        public Criteria andRuleActionTextNotEqualTo(String value) {
            addCriterion("rule_action_text <>", value, "ruleActionText");
            return (Criteria) this;
        }

        public Criteria andRuleActionTextGreaterThan(String value) {
            addCriterion("rule_action_text >", value, "ruleActionText");
            return (Criteria) this;
        }

        public Criteria andRuleActionTextGreaterThanOrEqualTo(String value) {
            addCriterion("rule_action_text >=", value, "ruleActionText");
            return (Criteria) this;
        }

        public Criteria andRuleActionTextLessThan(String value) {
            addCriterion("rule_action_text <", value, "ruleActionText");
            return (Criteria) this;
        }

        public Criteria andRuleActionTextLessThanOrEqualTo(String value) {
            addCriterion("rule_action_text <=", value, "ruleActionText");
            return (Criteria) this;
        }

        public Criteria andRuleActionTextLike(String value) {
            addCriterion("rule_action_text like", value, "ruleActionText");
            return (Criteria) this;
        }

        public Criteria andRuleActionTextNotLike(String value) {
            addCriterion("rule_action_text not like", value, "ruleActionText");
            return (Criteria) this;
        }

        public Criteria andRuleActionTextIn(List<String> values) {
            addCriterion("rule_action_text in", values, "ruleActionText");
            return (Criteria) this;
        }

        public Criteria andRuleActionTextNotIn(List<String> values) {
            addCriterion("rule_action_text not in", values, "ruleActionText");
            return (Criteria) this;
        }

        public Criteria andRuleActionTextBetween(String value1, String value2) {
            addCriterion("rule_action_text between", value1, value2, "ruleActionText");
            return (Criteria) this;
        }

        public Criteria andRuleActionTextNotBetween(String value1, String value2) {
            addCriterion("rule_action_text not between", value1, value2, "ruleActionText");
            return (Criteria) this;
        }

        public Criteria andRuleImportTextIsNull() {
            addCriterion("rule_import_text is null");
            return (Criteria) this;
        }

        public Criteria andRuleImportTextIsNotNull() {
            addCriterion("rule_import_text is not null");
            return (Criteria) this;
        }

        public Criteria andRuleImportTextEqualTo(String value) {
            addCriterion("rule_import_text =", value, "ruleImportText");
            return (Criteria) this;
        }

        public Criteria andRuleImportTextNotEqualTo(String value) {
            addCriterion("rule_import_text <>", value, "ruleImportText");
            return (Criteria) this;
        }

        public Criteria andRuleImportTextGreaterThan(String value) {
            addCriterion("rule_import_text >", value, "ruleImportText");
            return (Criteria) this;
        }

        public Criteria andRuleImportTextGreaterThanOrEqualTo(String value) {
            addCriterion("rule_import_text >=", value, "ruleImportText");
            return (Criteria) this;
        }

        public Criteria andRuleImportTextLessThan(String value) {
            addCriterion("rule_import_text <", value, "ruleImportText");
            return (Criteria) this;
        }

        public Criteria andRuleImportTextLessThanOrEqualTo(String value) {
            addCriterion("rule_import_text <=", value, "ruleImportText");
            return (Criteria) this;
        }

        public Criteria andRuleImportTextLike(String value) {
            addCriterion("rule_import_text like", value, "ruleImportText");
            return (Criteria) this;
        }

        public Criteria andRuleImportTextNotLike(String value) {
            addCriterion("rule_import_text not like", value, "ruleImportText");
            return (Criteria) this;
        }

        public Criteria andRuleImportTextIn(List<String> values) {
            addCriterion("rule_import_text in", values, "ruleImportText");
            return (Criteria) this;
        }

        public Criteria andRuleImportTextNotIn(List<String> values) {
            addCriterion("rule_import_text not in", values, "ruleImportText");
            return (Criteria) this;
        }

        public Criteria andRuleImportTextBetween(String value1, String value2) {
            addCriterion("rule_import_text between", value1, value2, "ruleImportText");
            return (Criteria) this;
        }

        public Criteria andRuleImportTextNotBetween(String value1, String value2) {
            addCriterion("rule_import_text not between", value1, value2, "ruleImportText");
            return (Criteria) this;
        }

        public Criteria andActivationGroupIsNull() {
            addCriterion("activation_group is null");
            return (Criteria) this;
        }

        public Criteria andActivationGroupIsNotNull() {
            addCriterion("activation_group is not null");
            return (Criteria) this;
        }

        public Criteria andActivationGroupEqualTo(String value) {
            addCriterion("activation_group =", value, "activationGroup");
            return (Criteria) this;
        }

        public Criteria andActivationGroupNotEqualTo(String value) {
            addCriterion("activation_group <>", value, "activationGroup");
            return (Criteria) this;
        }

        public Criteria andActivationGroupGreaterThan(String value) {
            addCriterion("activation_group >", value, "activationGroup");
            return (Criteria) this;
        }

        public Criteria andActivationGroupGreaterThanOrEqualTo(String value) {
            addCriterion("activation_group >=", value, "activationGroup");
            return (Criteria) this;
        }

        public Criteria andActivationGroupLessThan(String value) {
            addCriterion("activation_group <", value, "activationGroup");
            return (Criteria) this;
        }

        public Criteria andActivationGroupLessThanOrEqualTo(String value) {
            addCriterion("activation_group <=", value, "activationGroup");
            return (Criteria) this;
        }

        public Criteria andActivationGroupLike(String value) {
            addCriterion("activation_group like", value, "activationGroup");
            return (Criteria) this;
        }

        public Criteria andActivationGroupNotLike(String value) {
            addCriterion("activation_group not like", value, "activationGroup");
            return (Criteria) this;
        }

        public Criteria andActivationGroupIn(List<String> values) {
            addCriterion("activation_group in", values, "activationGroup");
            return (Criteria) this;
        }

        public Criteria andActivationGroupNotIn(List<String> values) {
            addCriterion("activation_group not in", values, "activationGroup");
            return (Criteria) this;
        }

        public Criteria andActivationGroupBetween(String value1, String value2) {
            addCriterion("activation_group between", value1, value2, "activationGroup");
            return (Criteria) this;
        }

        public Criteria andActivationGroupNotBetween(String value1, String value2) {
            addCriterion("activation_group not between", value1, value2, "activationGroup");
            return (Criteria) this;
        }

        public Criteria andAgendaGroupIsNull() {
            addCriterion("agenda_group is null");
            return (Criteria) this;
        }

        public Criteria andAgendaGroupIsNotNull() {
            addCriterion("agenda_group is not null");
            return (Criteria) this;
        }

        public Criteria andAgendaGroupEqualTo(String value) {
            addCriterion("agenda_group =", value, "agendaGroup");
            return (Criteria) this;
        }

        public Criteria andAgendaGroupNotEqualTo(String value) {
            addCriterion("agenda_group <>", value, "agendaGroup");
            return (Criteria) this;
        }

        public Criteria andAgendaGroupGreaterThan(String value) {
            addCriterion("agenda_group >", value, "agendaGroup");
            return (Criteria) this;
        }

        public Criteria andAgendaGroupGreaterThanOrEqualTo(String value) {
            addCriterion("agenda_group >=", value, "agendaGroup");
            return (Criteria) this;
        }

        public Criteria andAgendaGroupLessThan(String value) {
            addCriterion("agenda_group <", value, "agendaGroup");
            return (Criteria) this;
        }

        public Criteria andAgendaGroupLessThanOrEqualTo(String value) {
            addCriterion("agenda_group <=", value, "agendaGroup");
            return (Criteria) this;
        }

        public Criteria andAgendaGroupLike(String value) {
            addCriterion("agenda_group like", value, "agendaGroup");
            return (Criteria) this;
        }

        public Criteria andAgendaGroupNotLike(String value) {
            addCriterion("agenda_group not like", value, "agendaGroup");
            return (Criteria) this;
        }

        public Criteria andAgendaGroupIn(List<String> values) {
            addCriterion("agenda_group in", values, "agendaGroup");
            return (Criteria) this;
        }

        public Criteria andAgendaGroupNotIn(List<String> values) {
            addCriterion("agenda_group not in", values, "agendaGroup");
            return (Criteria) this;
        }

        public Criteria andAgendaGroupBetween(String value1, String value2) {
            addCriterion("agenda_group between", value1, value2, "agendaGroup");
            return (Criteria) this;
        }

        public Criteria andAgendaGroupNotBetween(String value1, String value2) {
            addCriterion("agenda_group not between", value1, value2, "agendaGroup");
            return (Criteria) this;
        }

        public Criteria andNoLoopIsNull() {
            addCriterion("no_loop is null");
            return (Criteria) this;
        }

        public Criteria andNoLoopIsNotNull() {
            addCriterion("no_loop is not null");
            return (Criteria) this;
        }

        public Criteria andNoLoopEqualTo(String value) {
            addCriterion("no_loop =", value, "noLoop");
            return (Criteria) this;
        }

        public Criteria andNoLoopNotEqualTo(String value) {
            addCriterion("no_loop <>", value, "noLoop");
            return (Criteria) this;
        }

        public Criteria andNoLoopGreaterThan(String value) {
            addCriterion("no_loop >", value, "noLoop");
            return (Criteria) this;
        }

        public Criteria andNoLoopGreaterThanOrEqualTo(String value) {
            addCriterion("no_loop >=", value, "noLoop");
            return (Criteria) this;
        }

        public Criteria andNoLoopLessThan(String value) {
            addCriterion("no_loop <", value, "noLoop");
            return (Criteria) this;
        }

        public Criteria andNoLoopLessThanOrEqualTo(String value) {
            addCriterion("no_loop <=", value, "noLoop");
            return (Criteria) this;
        }

        public Criteria andNoLoopLike(String value) {
            addCriterion("no_loop like", value, "noLoop");
            return (Criteria) this;
        }

        public Criteria andNoLoopNotLike(String value) {
            addCriterion("no_loop not like", value, "noLoop");
            return (Criteria) this;
        }

        public Criteria andNoLoopIn(List<String> values) {
            addCriterion("no_loop in", values, "noLoop");
            return (Criteria) this;
        }

        public Criteria andNoLoopNotIn(List<String> values) {
            addCriterion("no_loop not in", values, "noLoop");
            return (Criteria) this;
        }

        public Criteria andNoLoopBetween(String value1, String value2) {
            addCriterion("no_loop between", value1, value2, "noLoop");
            return (Criteria) this;
        }

        public Criteria andNoLoopNotBetween(String value1, String value2) {
            addCriterion("no_loop not between", value1, value2, "noLoop");
            return (Criteria) this;
        }

        public Criteria andDateEffectiveIsNull() {
            addCriterion("date_effective is null");
            return (Criteria) this;
        }

        public Criteria andDateEffectiveIsNotNull() {
            addCriterion("date_effective is not null");
            return (Criteria) this;
        }

        public Criteria andDateEffectiveEqualTo(String value) {
            addCriterion("date_effective =", value, "dateEffective");
            return (Criteria) this;
        }

        public Criteria andDateEffectiveNotEqualTo(String value) {
            addCriterion("date_effective <>", value, "dateEffective");
            return (Criteria) this;
        }

        public Criteria andDateEffectiveGreaterThan(String value) {
            addCriterion("date_effective >", value, "dateEffective");
            return (Criteria) this;
        }

        public Criteria andDateEffectiveGreaterThanOrEqualTo(String value) {
            addCriterion("date_effective >=", value, "dateEffective");
            return (Criteria) this;
        }

        public Criteria andDateEffectiveLessThan(String value) {
            addCriterion("date_effective <", value, "dateEffective");
            return (Criteria) this;
        }

        public Criteria andDateEffectiveLessThanOrEqualTo(String value) {
            addCriterion("date_effective <=", value, "dateEffective");
            return (Criteria) this;
        }

        public Criteria andDateEffectiveLike(String value) {
            addCriterion("date_effective like", value, "dateEffective");
            return (Criteria) this;
        }

        public Criteria andDateEffectiveNotLike(String value) {
            addCriterion("date_effective not like", value, "dateEffective");
            return (Criteria) this;
        }

        public Criteria andDateEffectiveIn(List<String> values) {
            addCriterion("date_effective in", values, "dateEffective");
            return (Criteria) this;
        }

        public Criteria andDateEffectiveNotIn(List<String> values) {
            addCriterion("date_effective not in", values, "dateEffective");
            return (Criteria) this;
        }

        public Criteria andDateEffectiveBetween(String value1, String value2) {
            addCriterion("date_effective between", value1, value2, "dateEffective");
            return (Criteria) this;
        }

        public Criteria andDateEffectiveNotBetween(String value1, String value2) {
            addCriterion("date_effective not between", value1, value2, "dateEffective");
            return (Criteria) this;
        }

        public Criteria andDateExpiresIsNull() {
            addCriterion("date_expires is null");
            return (Criteria) this;
        }

        public Criteria andDateExpiresIsNotNull() {
            addCriterion("date_expires is not null");
            return (Criteria) this;
        }

        public Criteria andDateExpiresEqualTo(String value) {
            addCriterion("date_expires =", value, "dateExpires");
            return (Criteria) this;
        }

        public Criteria andDateExpiresNotEqualTo(String value) {
            addCriterion("date_expires <>", value, "dateExpires");
            return (Criteria) this;
        }

        public Criteria andDateExpiresGreaterThan(String value) {
            addCriterion("date_expires >", value, "dateExpires");
            return (Criteria) this;
        }

        public Criteria andDateExpiresGreaterThanOrEqualTo(String value) {
            addCriterion("date_expires >=", value, "dateExpires");
            return (Criteria) this;
        }

        public Criteria andDateExpiresLessThan(String value) {
            addCriterion("date_expires <", value, "dateExpires");
            return (Criteria) this;
        }

        public Criteria andDateExpiresLessThanOrEqualTo(String value) {
            addCriterion("date_expires <=", value, "dateExpires");
            return (Criteria) this;
        }

        public Criteria andDateExpiresLike(String value) {
            addCriterion("date_expires like", value, "dateExpires");
            return (Criteria) this;
        }

        public Criteria andDateExpiresNotLike(String value) {
            addCriterion("date_expires not like", value, "dateExpires");
            return (Criteria) this;
        }

        public Criteria andDateExpiresIn(List<String> values) {
            addCriterion("date_expires in", values, "dateExpires");
            return (Criteria) this;
        }

        public Criteria andDateExpiresNotIn(List<String> values) {
            addCriterion("date_expires not in", values, "dateExpires");
            return (Criteria) this;
        }

        public Criteria andDateExpiresBetween(String value1, String value2) {
            addCriterion("date_expires between", value1, value2, "dateExpires");
            return (Criteria) this;
        }

        public Criteria andDateExpiresNotBetween(String value1, String value2) {
            addCriterion("date_expires not between", value1, value2, "dateExpires");
            return (Criteria) this;
        }

        public Criteria andSalienceIsNull() {
            addCriterion("salience is null");
            return (Criteria) this;
        }

        public Criteria andSalienceIsNotNull() {
            addCriterion("salience is not null");
            return (Criteria) this;
        }

        public Criteria andSalienceEqualTo(Integer value) {
            addCriterion("salience =", value, "salience");
            return (Criteria) this;
        }

        public Criteria andSalienceNotEqualTo(Integer value) {
            addCriterion("salience <>", value, "salience");
            return (Criteria) this;
        }

        public Criteria andSalienceGreaterThan(Integer value) {
            addCriterion("salience >", value, "salience");
            return (Criteria) this;
        }

        public Criteria andSalienceGreaterThanOrEqualTo(Integer value) {
            addCriterion("salience >=", value, "salience");
            return (Criteria) this;
        }

        public Criteria andSalienceLessThan(Integer value) {
            addCriterion("salience <", value, "salience");
            return (Criteria) this;
        }

        public Criteria andSalienceLessThanOrEqualTo(Integer value) {
            addCriterion("salience <=", value, "salience");
            return (Criteria) this;
        }

        public Criteria andSalienceIn(List<Integer> values) {
            addCriterion("salience in", values, "salience");
            return (Criteria) this;
        }

        public Criteria andSalienceNotIn(List<Integer> values) {
            addCriterion("salience not in", values, "salience");
            return (Criteria) this;
        }

        public Criteria andSalienceBetween(Integer value1, Integer value2) {
            addCriterion("salience between", value1, value2, "salience");
            return (Criteria) this;
        }

        public Criteria andSalienceNotBetween(Integer value1, Integer value2) {
            addCriterion("salience not between", value1, value2, "salience");
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
        private RuleExample example;

        protected Criteria(RuleExample example) {
            super();
            this.example = example;
        }

        public RuleExample example() {
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
        void example(RuleExample example);
    }
}