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

        public Criteria andRuleAttrIsNull() {
            addCriterion("rule_attr is null");
            return (Criteria) this;
        }

        public Criteria andRuleAttrIsNotNull() {
            addCriterion("rule_attr is not null");
            return (Criteria) this;
        }

        public Criteria andRuleAttrEqualTo(String value) {
            addCriterion("rule_attr =", value, "ruleAttr");
            return (Criteria) this;
        }

        public Criteria andRuleAttrNotEqualTo(String value) {
            addCriterion("rule_attr <>", value, "ruleAttr");
            return (Criteria) this;
        }

        public Criteria andRuleAttrGreaterThan(String value) {
            addCriterion("rule_attr >", value, "ruleAttr");
            return (Criteria) this;
        }

        public Criteria andRuleAttrGreaterThanOrEqualTo(String value) {
            addCriterion("rule_attr >=", value, "ruleAttr");
            return (Criteria) this;
        }

        public Criteria andRuleAttrLessThan(String value) {
            addCriterion("rule_attr <", value, "ruleAttr");
            return (Criteria) this;
        }

        public Criteria andRuleAttrLessThanOrEqualTo(String value) {
            addCriterion("rule_attr <=", value, "ruleAttr");
            return (Criteria) this;
        }

        public Criteria andRuleAttrLike(String value) {
            addCriterion("rule_attr like", value, "ruleAttr");
            return (Criteria) this;
        }

        public Criteria andRuleAttrNotLike(String value) {
            addCriterion("rule_attr not like", value, "ruleAttr");
            return (Criteria) this;
        }

        public Criteria andRuleAttrIn(List<String> values) {
            addCriterion("rule_attr in", values, "ruleAttr");
            return (Criteria) this;
        }

        public Criteria andRuleAttrNotIn(List<String> values) {
            addCriterion("rule_attr not in", values, "ruleAttr");
            return (Criteria) this;
        }

        public Criteria andRuleAttrBetween(String value1, String value2) {
            addCriterion("rule_attr between", value1, value2, "ruleAttr");
            return (Criteria) this;
        }

        public Criteria andRuleAttrNotBetween(String value1, String value2) {
            addCriterion("rule_attr not between", value1, value2, "ruleAttr");
            return (Criteria) this;
        }

        public Criteria andRuleLhsIsNull() {
            addCriterion("rule_lhs is null");
            return (Criteria) this;
        }

        public Criteria andRuleLhsIsNotNull() {
            addCriterion("rule_lhs is not null");
            return (Criteria) this;
        }

        public Criteria andRuleLhsEqualTo(String value) {
            addCriterion("rule_lhs =", value, "ruleLhs");
            return (Criteria) this;
        }

        public Criteria andRuleLhsNotEqualTo(String value) {
            addCriterion("rule_lhs <>", value, "ruleLhs");
            return (Criteria) this;
        }

        public Criteria andRuleLhsGreaterThan(String value) {
            addCriterion("rule_lhs >", value, "ruleLhs");
            return (Criteria) this;
        }

        public Criteria andRuleLhsGreaterThanOrEqualTo(String value) {
            addCriterion("rule_lhs >=", value, "ruleLhs");
            return (Criteria) this;
        }

        public Criteria andRuleLhsLessThan(String value) {
            addCriterion("rule_lhs <", value, "ruleLhs");
            return (Criteria) this;
        }

        public Criteria andRuleLhsLessThanOrEqualTo(String value) {
            addCriterion("rule_lhs <=", value, "ruleLhs");
            return (Criteria) this;
        }

        public Criteria andRuleLhsLike(String value) {
            addCriterion("rule_lhs like", value, "ruleLhs");
            return (Criteria) this;
        }

        public Criteria andRuleLhsNotLike(String value) {
            addCriterion("rule_lhs not like", value, "ruleLhs");
            return (Criteria) this;
        }

        public Criteria andRuleLhsIn(List<String> values) {
            addCriterion("rule_lhs in", values, "ruleLhs");
            return (Criteria) this;
        }

        public Criteria andRuleLhsNotIn(List<String> values) {
            addCriterion("rule_lhs not in", values, "ruleLhs");
            return (Criteria) this;
        }

        public Criteria andRuleLhsBetween(String value1, String value2) {
            addCriterion("rule_lhs between", value1, value2, "ruleLhs");
            return (Criteria) this;
        }

        public Criteria andRuleLhsNotBetween(String value1, String value2) {
            addCriterion("rule_lhs not between", value1, value2, "ruleLhs");
            return (Criteria) this;
        }

        public Criteria andRuleRhsIsNull() {
            addCriterion("rule_rhs is null");
            return (Criteria) this;
        }

        public Criteria andRuleRhsIsNotNull() {
            addCriterion("rule_rhs is not null");
            return (Criteria) this;
        }

        public Criteria andRuleRhsEqualTo(String value) {
            addCriterion("rule_rhs =", value, "ruleRhs");
            return (Criteria) this;
        }

        public Criteria andRuleRhsNotEqualTo(String value) {
            addCriterion("rule_rhs <>", value, "ruleRhs");
            return (Criteria) this;
        }

        public Criteria andRuleRhsGreaterThan(String value) {
            addCriterion("rule_rhs >", value, "ruleRhs");
            return (Criteria) this;
        }

        public Criteria andRuleRhsGreaterThanOrEqualTo(String value) {
            addCriterion("rule_rhs >=", value, "ruleRhs");
            return (Criteria) this;
        }

        public Criteria andRuleRhsLessThan(String value) {
            addCriterion("rule_rhs <", value, "ruleRhs");
            return (Criteria) this;
        }

        public Criteria andRuleRhsLessThanOrEqualTo(String value) {
            addCriterion("rule_rhs <=", value, "ruleRhs");
            return (Criteria) this;
        }

        public Criteria andRuleRhsLike(String value) {
            addCriterion("rule_rhs like", value, "ruleRhs");
            return (Criteria) this;
        }

        public Criteria andRuleRhsNotLike(String value) {
            addCriterion("rule_rhs not like", value, "ruleRhs");
            return (Criteria) this;
        }

        public Criteria andRuleRhsIn(List<String> values) {
            addCriterion("rule_rhs in", values, "ruleRhs");
            return (Criteria) this;
        }

        public Criteria andRuleRhsNotIn(List<String> values) {
            addCriterion("rule_rhs not in", values, "ruleRhs");
            return (Criteria) this;
        }

        public Criteria andRuleRhsBetween(String value1, String value2) {
            addCriterion("rule_rhs between", value1, value2, "ruleRhs");
            return (Criteria) this;
        }

        public Criteria andRuleRhsNotBetween(String value1, String value2) {
            addCriterion("rule_rhs not between", value1, value2, "ruleRhs");
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
        void example(com.weweibuy.brms.model.example.RuleExample example);
    }
}