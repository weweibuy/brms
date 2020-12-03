package com.weweibuy.brms.model.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RuleHitLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RuleHitLogExample() {
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

    public RuleHitLogExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public RuleHitLogExample orderBy(String ... orderByClauses) {
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
        RuleHitLogExample example = new RuleHitLogExample();
        return example.createCriteria();
    }

    public RuleHitLogExample when(boolean condition, IExampleWhen then) {
        if (condition) {
            then.example(this);
        }
        return this;
    }

    public RuleHitLogExample when(boolean condition, IExampleWhen then, IExampleWhen otherwise) {
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

        public Criteria andRequestNoIsNull() {
            addCriterion("request_no is null");
            return (Criteria) this;
        }

        public Criteria andRequestNoIsNotNull() {
            addCriterion("request_no is not null");
            return (Criteria) this;
        }

        public Criteria andRequestNoEqualTo(String value) {
            addCriterion("request_no =", value, "requestNo");
            return (Criteria) this;
        }

        public Criteria andRequestNoNotEqualTo(String value) {
            addCriterion("request_no <>", value, "requestNo");
            return (Criteria) this;
        }

        public Criteria andRequestNoGreaterThan(String value) {
            addCriterion("request_no >", value, "requestNo");
            return (Criteria) this;
        }

        public Criteria andRequestNoGreaterThanOrEqualTo(String value) {
            addCriterion("request_no >=", value, "requestNo");
            return (Criteria) this;
        }

        public Criteria andRequestNoLessThan(String value) {
            addCriterion("request_no <", value, "requestNo");
            return (Criteria) this;
        }

        public Criteria andRequestNoLessThanOrEqualTo(String value) {
            addCriterion("request_no <=", value, "requestNo");
            return (Criteria) this;
        }

        public Criteria andRequestNoLike(String value) {
            addCriterion("request_no like", value, "requestNo");
            return (Criteria) this;
        }

        public Criteria andRequestNoNotLike(String value) {
            addCriterion("request_no not like", value, "requestNo");
            return (Criteria) this;
        }

        public Criteria andRequestNoIn(List<String> values) {
            addCriterion("request_no in", values, "requestNo");
            return (Criteria) this;
        }

        public Criteria andRequestNoNotIn(List<String> values) {
            addCriterion("request_no not in", values, "requestNo");
            return (Criteria) this;
        }

        public Criteria andRequestNoBetween(String value1, String value2) {
            addCriterion("request_no between", value1, value2, "requestNo");
            return (Criteria) this;
        }

        public Criteria andRequestNoNotBetween(String value1, String value2) {
            addCriterion("request_no not between", value1, value2, "requestNo");
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

        public Criteria andInputModelIsNull() {
            addCriterion("input_model is null");
            return (Criteria) this;
        }

        public Criteria andInputModelIsNotNull() {
            addCriterion("input_model is not null");
            return (Criteria) this;
        }

        public Criteria andInputModelEqualTo(String value) {
            addCriterion("input_model =", value, "inputModel");
            return (Criteria) this;
        }

        public Criteria andInputModelNotEqualTo(String value) {
            addCriterion("input_model <>", value, "inputModel");
            return (Criteria) this;
        }

        public Criteria andInputModelGreaterThan(String value) {
            addCriterion("input_model >", value, "inputModel");
            return (Criteria) this;
        }

        public Criteria andInputModelGreaterThanOrEqualTo(String value) {
            addCriterion("input_model >=", value, "inputModel");
            return (Criteria) this;
        }

        public Criteria andInputModelLessThan(String value) {
            addCriterion("input_model <", value, "inputModel");
            return (Criteria) this;
        }

        public Criteria andInputModelLessThanOrEqualTo(String value) {
            addCriterion("input_model <=", value, "inputModel");
            return (Criteria) this;
        }

        public Criteria andInputModelLike(String value) {
            addCriterion("input_model like", value, "inputModel");
            return (Criteria) this;
        }

        public Criteria andInputModelNotLike(String value) {
            addCriterion("input_model not like", value, "inputModel");
            return (Criteria) this;
        }

        public Criteria andInputModelIn(List<String> values) {
            addCriterion("input_model in", values, "inputModel");
            return (Criteria) this;
        }

        public Criteria andInputModelNotIn(List<String> values) {
            addCriterion("input_model not in", values, "inputModel");
            return (Criteria) this;
        }

        public Criteria andInputModelBetween(String value1, String value2) {
            addCriterion("input_model between", value1, value2, "inputModel");
            return (Criteria) this;
        }

        public Criteria andInputModelNotBetween(String value1, String value2) {
            addCriterion("input_model not between", value1, value2, "inputModel");
            return (Criteria) this;
        }

        public Criteria andOutputModelIsNull() {
            addCriterion("output_model is null");
            return (Criteria) this;
        }

        public Criteria andOutputModelIsNotNull() {
            addCriterion("output_model is not null");
            return (Criteria) this;
        }

        public Criteria andOutputModelEqualTo(String value) {
            addCriterion("output_model =", value, "outputModel");
            return (Criteria) this;
        }

        public Criteria andOutputModelNotEqualTo(String value) {
            addCriterion("output_model <>", value, "outputModel");
            return (Criteria) this;
        }

        public Criteria andOutputModelGreaterThan(String value) {
            addCriterion("output_model >", value, "outputModel");
            return (Criteria) this;
        }

        public Criteria andOutputModelGreaterThanOrEqualTo(String value) {
            addCriterion("output_model >=", value, "outputModel");
            return (Criteria) this;
        }

        public Criteria andOutputModelLessThan(String value) {
            addCriterion("output_model <", value, "outputModel");
            return (Criteria) this;
        }

        public Criteria andOutputModelLessThanOrEqualTo(String value) {
            addCriterion("output_model <=", value, "outputModel");
            return (Criteria) this;
        }

        public Criteria andOutputModelLike(String value) {
            addCriterion("output_model like", value, "outputModel");
            return (Criteria) this;
        }

        public Criteria andOutputModelNotLike(String value) {
            addCriterion("output_model not like", value, "outputModel");
            return (Criteria) this;
        }

        public Criteria andOutputModelIn(List<String> values) {
            addCriterion("output_model in", values, "outputModel");
            return (Criteria) this;
        }

        public Criteria andOutputModelNotIn(List<String> values) {
            addCriterion("output_model not in", values, "outputModel");
            return (Criteria) this;
        }

        public Criteria andOutputModelBetween(String value1, String value2) {
            addCriterion("output_model between", value1, value2, "outputModel");
            return (Criteria) this;
        }

        public Criteria andOutputModelNotBetween(String value1, String value2) {
            addCriterion("output_model not between", value1, value2, "outputModel");
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
        private RuleHitLogExample example;

        protected Criteria(RuleHitLogExample example) {
            super();
            this.example = example;
        }

        public RuleHitLogExample example() {
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
        void example(RuleHitLogExample example);
    }
}