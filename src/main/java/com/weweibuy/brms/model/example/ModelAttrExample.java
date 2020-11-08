package com.weweibuy.brms.model.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ModelAttrExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ModelAttrExample() {
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

    public ModelAttrExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public ModelAttrExample orderBy(String ... orderByClauses) {
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
        ModelAttrExample example = new ModelAttrExample();
        return example.createCriteria();
    }

    public ModelAttrExample when(boolean condition, IExampleWhen then) {
        if (condition) {
            then.example(this);
        }
        return this;
    }

    public ModelAttrExample when(boolean condition, IExampleWhen then, IExampleWhen otherwise) {
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

        public Criteria andModelKeyIsNull() {
            addCriterion("model_key is null");
            return (Criteria) this;
        }

        public Criteria andModelKeyIsNotNull() {
            addCriterion("model_key is not null");
            return (Criteria) this;
        }

        public Criteria andModelKeyEqualTo(String value) {
            addCriterion("model_key =", value, "modelKey");
            return (Criteria) this;
        }

        public Criteria andModelKeyNotEqualTo(String value) {
            addCriterion("model_key <>", value, "modelKey");
            return (Criteria) this;
        }

        public Criteria andModelKeyGreaterThan(String value) {
            addCriterion("model_key >", value, "modelKey");
            return (Criteria) this;
        }

        public Criteria andModelKeyGreaterThanOrEqualTo(String value) {
            addCriterion("model_key >=", value, "modelKey");
            return (Criteria) this;
        }

        public Criteria andModelKeyLessThan(String value) {
            addCriterion("model_key <", value, "modelKey");
            return (Criteria) this;
        }

        public Criteria andModelKeyLessThanOrEqualTo(String value) {
            addCriterion("model_key <=", value, "modelKey");
            return (Criteria) this;
        }

        public Criteria andModelKeyLike(String value) {
            addCriterion("model_key like", value, "modelKey");
            return (Criteria) this;
        }

        public Criteria andModelKeyNotLike(String value) {
            addCriterion("model_key not like", value, "modelKey");
            return (Criteria) this;
        }

        public Criteria andModelKeyIn(List<String> values) {
            addCriterion("model_key in", values, "modelKey");
            return (Criteria) this;
        }

        public Criteria andModelKeyNotIn(List<String> values) {
            addCriterion("model_key not in", values, "modelKey");
            return (Criteria) this;
        }

        public Criteria andModelKeyBetween(String value1, String value2) {
            addCriterion("model_key between", value1, value2, "modelKey");
            return (Criteria) this;
        }

        public Criteria andModelKeyNotBetween(String value1, String value2) {
            addCriterion("model_key not between", value1, value2, "modelKey");
            return (Criteria) this;
        }

        public Criteria andAttrKeyIsNull() {
            addCriterion("attr_key is null");
            return (Criteria) this;
        }

        public Criteria andAttrKeyIsNotNull() {
            addCriterion("attr_key is not null");
            return (Criteria) this;
        }

        public Criteria andAttrKeyEqualTo(String value) {
            addCriterion("attr_key =", value, "attrKey");
            return (Criteria) this;
        }

        public Criteria andAttrKeyNotEqualTo(String value) {
            addCriterion("attr_key <>", value, "attrKey");
            return (Criteria) this;
        }

        public Criteria andAttrKeyGreaterThan(String value) {
            addCriterion("attr_key >", value, "attrKey");
            return (Criteria) this;
        }

        public Criteria andAttrKeyGreaterThanOrEqualTo(String value) {
            addCriterion("attr_key >=", value, "attrKey");
            return (Criteria) this;
        }

        public Criteria andAttrKeyLessThan(String value) {
            addCriterion("attr_key <", value, "attrKey");
            return (Criteria) this;
        }

        public Criteria andAttrKeyLessThanOrEqualTo(String value) {
            addCriterion("attr_key <=", value, "attrKey");
            return (Criteria) this;
        }

        public Criteria andAttrKeyLike(String value) {
            addCriterion("attr_key like", value, "attrKey");
            return (Criteria) this;
        }

        public Criteria andAttrKeyNotLike(String value) {
            addCriterion("attr_key not like", value, "attrKey");
            return (Criteria) this;
        }

        public Criteria andAttrKeyIn(List<String> values) {
            addCriterion("attr_key in", values, "attrKey");
            return (Criteria) this;
        }

        public Criteria andAttrKeyNotIn(List<String> values) {
            addCriterion("attr_key not in", values, "attrKey");
            return (Criteria) this;
        }

        public Criteria andAttrKeyBetween(String value1, String value2) {
            addCriterion("attr_key between", value1, value2, "attrKey");
            return (Criteria) this;
        }

        public Criteria andAttrKeyNotBetween(String value1, String value2) {
            addCriterion("attr_key not between", value1, value2, "attrKey");
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

        public Criteria andAttrDescIsNull() {
            addCriterion("attr_desc is null");
            return (Criteria) this;
        }

        public Criteria andAttrDescIsNotNull() {
            addCriterion("attr_desc is not null");
            return (Criteria) this;
        }

        public Criteria andAttrDescEqualTo(String value) {
            addCriterion("attr_desc =", value, "attrDesc");
            return (Criteria) this;
        }

        public Criteria andAttrDescNotEqualTo(String value) {
            addCriterion("attr_desc <>", value, "attrDesc");
            return (Criteria) this;
        }

        public Criteria andAttrDescGreaterThan(String value) {
            addCriterion("attr_desc >", value, "attrDesc");
            return (Criteria) this;
        }

        public Criteria andAttrDescGreaterThanOrEqualTo(String value) {
            addCriterion("attr_desc >=", value, "attrDesc");
            return (Criteria) this;
        }

        public Criteria andAttrDescLessThan(String value) {
            addCriterion("attr_desc <", value, "attrDesc");
            return (Criteria) this;
        }

        public Criteria andAttrDescLessThanOrEqualTo(String value) {
            addCriterion("attr_desc <=", value, "attrDesc");
            return (Criteria) this;
        }

        public Criteria andAttrDescLike(String value) {
            addCriterion("attr_desc like", value, "attrDesc");
            return (Criteria) this;
        }

        public Criteria andAttrDescNotLike(String value) {
            addCriterion("attr_desc not like", value, "attrDesc");
            return (Criteria) this;
        }

        public Criteria andAttrDescIn(List<String> values) {
            addCriterion("attr_desc in", values, "attrDesc");
            return (Criteria) this;
        }

        public Criteria andAttrDescNotIn(List<String> values) {
            addCriterion("attr_desc not in", values, "attrDesc");
            return (Criteria) this;
        }

        public Criteria andAttrDescBetween(String value1, String value2) {
            addCriterion("attr_desc between", value1, value2, "attrDesc");
            return (Criteria) this;
        }

        public Criteria andAttrDescNotBetween(String value1, String value2) {
            addCriterion("attr_desc not between", value1, value2, "attrDesc");
            return (Criteria) this;
        }

        public Criteria andAttrTypeIsNull() {
            addCriterion("attr_type is null");
            return (Criteria) this;
        }

        public Criteria andAttrTypeIsNotNull() {
            addCriterion("attr_type is not null");
            return (Criteria) this;
        }

        public Criteria andAttrTypeEqualTo(String value) {
            addCriterion("attr_type =", value, "attrType");
            return (Criteria) this;
        }

        public Criteria andAttrTypeNotEqualTo(String value) {
            addCriterion("attr_type <>", value, "attrType");
            return (Criteria) this;
        }

        public Criteria andAttrTypeGreaterThan(String value) {
            addCriterion("attr_type >", value, "attrType");
            return (Criteria) this;
        }

        public Criteria andAttrTypeGreaterThanOrEqualTo(String value) {
            addCriterion("attr_type >=", value, "attrType");
            return (Criteria) this;
        }

        public Criteria andAttrTypeLessThan(String value) {
            addCriterion("attr_type <", value, "attrType");
            return (Criteria) this;
        }

        public Criteria andAttrTypeLessThanOrEqualTo(String value) {
            addCriterion("attr_type <=", value, "attrType");
            return (Criteria) this;
        }

        public Criteria andAttrTypeLike(String value) {
            addCriterion("attr_type like", value, "attrType");
            return (Criteria) this;
        }

        public Criteria andAttrTypeNotLike(String value) {
            addCriterion("attr_type not like", value, "attrType");
            return (Criteria) this;
        }

        public Criteria andAttrTypeIn(List<String> values) {
            addCriterion("attr_type in", values, "attrType");
            return (Criteria) this;
        }

        public Criteria andAttrTypeNotIn(List<String> values) {
            addCriterion("attr_type not in", values, "attrType");
            return (Criteria) this;
        }

        public Criteria andAttrTypeBetween(String value1, String value2) {
            addCriterion("attr_type between", value1, value2, "attrType");
            return (Criteria) this;
        }

        public Criteria andAttrTypeNotBetween(String value1, String value2) {
            addCriterion("attr_type not between", value1, value2, "attrType");
            return (Criteria) this;
        }

        public Criteria andAttrValueSourceIsNull() {
            addCriterion("attr_value_source is null");
            return (Criteria) this;
        }

        public Criteria andAttrValueSourceIsNotNull() {
            addCriterion("attr_value_source is not null");
            return (Criteria) this;
        }

        public Criteria andAttrValueSourceEqualTo(String value) {
            addCriterion("attr_value_source =", value, "attrValueSource");
            return (Criteria) this;
        }

        public Criteria andAttrValueSourceNotEqualTo(String value) {
            addCriterion("attr_value_source <>", value, "attrValueSource");
            return (Criteria) this;
        }

        public Criteria andAttrValueSourceGreaterThan(String value) {
            addCriterion("attr_value_source >", value, "attrValueSource");
            return (Criteria) this;
        }

        public Criteria andAttrValueSourceGreaterThanOrEqualTo(String value) {
            addCriterion("attr_value_source >=", value, "attrValueSource");
            return (Criteria) this;
        }

        public Criteria andAttrValueSourceLessThan(String value) {
            addCriterion("attr_value_source <", value, "attrValueSource");
            return (Criteria) this;
        }

        public Criteria andAttrValueSourceLessThanOrEqualTo(String value) {
            addCriterion("attr_value_source <=", value, "attrValueSource");
            return (Criteria) this;
        }

        public Criteria andAttrValueSourceLike(String value) {
            addCriterion("attr_value_source like", value, "attrValueSource");
            return (Criteria) this;
        }

        public Criteria andAttrValueSourceNotLike(String value) {
            addCriterion("attr_value_source not like", value, "attrValueSource");
            return (Criteria) this;
        }

        public Criteria andAttrValueSourceIn(List<String> values) {
            addCriterion("attr_value_source in", values, "attrValueSource");
            return (Criteria) this;
        }

        public Criteria andAttrValueSourceNotIn(List<String> values) {
            addCriterion("attr_value_source not in", values, "attrValueSource");
            return (Criteria) this;
        }

        public Criteria andAttrValueSourceBetween(String value1, String value2) {
            addCriterion("attr_value_source between", value1, value2, "attrValueSource");
            return (Criteria) this;
        }

        public Criteria andAttrValueSourceNotBetween(String value1, String value2) {
            addCriterion("attr_value_source not between", value1, value2, "attrValueSource");
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
        private ModelAttrExample example;

        protected Criteria(ModelAttrExample example) {
            super();
            this.example = example;
        }

        public ModelAttrExample example() {
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
        void example(com.weweibuy.brms.model.example.ModelAttrExample example);
    }
}