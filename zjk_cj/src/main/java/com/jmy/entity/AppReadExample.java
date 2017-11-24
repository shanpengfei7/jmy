package com.jmy.entity;

import java.util.ArrayList;
import java.util.List;

public class AppReadExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table app_read
	 * @mbggenerated  Thu Jun 15 15:30:48 CST 2017
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table app_read
	 * @mbggenerated  Thu Jun 15 15:30:48 CST 2017
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table app_read
	 * @mbggenerated  Thu Jun 15 15:30:48 CST 2017
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table app_read
	 * @mbggenerated  Thu Jun 15 15:30:48 CST 2017
	 */
	public AppReadExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table app_read
	 * @mbggenerated  Thu Jun 15 15:30:48 CST 2017
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table app_read
	 * @mbggenerated  Thu Jun 15 15:30:48 CST 2017
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table app_read
	 * @mbggenerated  Thu Jun 15 15:30:48 CST 2017
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table app_read
	 * @mbggenerated  Thu Jun 15 15:30:48 CST 2017
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table app_read
	 * @mbggenerated  Thu Jun 15 15:30:48 CST 2017
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table app_read
	 * @mbggenerated  Thu Jun 15 15:30:48 CST 2017
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table app_read
	 * @mbggenerated  Thu Jun 15 15:30:48 CST 2017
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table app_read
	 * @mbggenerated  Thu Jun 15 15:30:48 CST 2017
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table app_read
	 * @mbggenerated  Thu Jun 15 15:30:48 CST 2017
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table app_read
	 * @mbggenerated  Thu Jun 15 15:30:48 CST 2017
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table app_read
	 * @mbggenerated  Thu Jun 15 15:30:48 CST 2017
	 */
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

		public Criteria andEnterpriseIdIsNull() {
			addCriterion("enterprise_id is null");
			return (Criteria) this;
		}

		public Criteria andEnterpriseIdIsNotNull() {
			addCriterion("enterprise_id is not null");
			return (Criteria) this;
		}

		public Criteria andEnterpriseIdEqualTo(Integer value) {
			addCriterion("enterprise_id =", value, "enterpriseId");
			return (Criteria) this;
		}

		public Criteria andEnterpriseIdNotEqualTo(Integer value) {
			addCriterion("enterprise_id <>", value, "enterpriseId");
			return (Criteria) this;
		}

		public Criteria andEnterpriseIdGreaterThan(Integer value) {
			addCriterion("enterprise_id >", value, "enterpriseId");
			return (Criteria) this;
		}

		public Criteria andEnterpriseIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("enterprise_id >=", value, "enterpriseId");
			return (Criteria) this;
		}

		public Criteria andEnterpriseIdLessThan(Integer value) {
			addCriterion("enterprise_id <", value, "enterpriseId");
			return (Criteria) this;
		}

		public Criteria andEnterpriseIdLessThanOrEqualTo(Integer value) {
			addCriterion("enterprise_id <=", value, "enterpriseId");
			return (Criteria) this;
		}

		public Criteria andEnterpriseIdIn(List<Integer> values) {
			addCriterion("enterprise_id in", values, "enterpriseId");
			return (Criteria) this;
		}

		public Criteria andEnterpriseIdNotIn(List<Integer> values) {
			addCriterion("enterprise_id not in", values, "enterpriseId");
			return (Criteria) this;
		}

		public Criteria andEnterpriseIdBetween(Integer value1, Integer value2) {
			addCriterion("enterprise_id between", value1, value2, "enterpriseId");
			return (Criteria) this;
		}

		public Criteria andEnterpriseIdNotBetween(Integer value1, Integer value2) {
			addCriterion("enterprise_id not between", value1, value2, "enterpriseId");
			return (Criteria) this;
		}

		public Criteria andAppIdIsNull() {
			addCriterion("app_id is null");
			return (Criteria) this;
		}

		public Criteria andAppIdIsNotNull() {
			addCriterion("app_id is not null");
			return (Criteria) this;
		}

		public Criteria andAppIdEqualTo(Integer value) {
			addCriterion("app_id =", value, "appId");
			return (Criteria) this;
		}

		public Criteria andAppIdNotEqualTo(Integer value) {
			addCriterion("app_id <>", value, "appId");
			return (Criteria) this;
		}

		public Criteria andAppIdGreaterThan(Integer value) {
			addCriterion("app_id >", value, "appId");
			return (Criteria) this;
		}

		public Criteria andAppIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("app_id >=", value, "appId");
			return (Criteria) this;
		}

		public Criteria andAppIdLessThan(Integer value) {
			addCriterion("app_id <", value, "appId");
			return (Criteria) this;
		}

		public Criteria andAppIdLessThanOrEqualTo(Integer value) {
			addCriterion("app_id <=", value, "appId");
			return (Criteria) this;
		}

		public Criteria andAppIdIn(List<Integer> values) {
			addCriterion("app_id in", values, "appId");
			return (Criteria) this;
		}

		public Criteria andAppIdNotIn(List<Integer> values) {
			addCriterion("app_id not in", values, "appId");
			return (Criteria) this;
		}

		public Criteria andAppIdBetween(Integer value1, Integer value2) {
			addCriterion("app_id between", value1, value2, "appId");
			return (Criteria) this;
		}

		public Criteria andAppIdNotBetween(Integer value1, Integer value2) {
			addCriterion("app_id not between", value1, value2, "appId");
			return (Criteria) this;
		}

		public Criteria andIsReadIsNull() {
			addCriterion("is_read is null");
			return (Criteria) this;
		}

		public Criteria andIsReadIsNotNull() {
			addCriterion("is_read is not null");
			return (Criteria) this;
		}

		public Criteria andIsReadEqualTo(Byte value) {
			addCriterion("is_read =", value, "isRead");
			return (Criteria) this;
		}

		public Criteria andIsReadNotEqualTo(Byte value) {
			addCriterion("is_read <>", value, "isRead");
			return (Criteria) this;
		}

		public Criteria andIsReadGreaterThan(Byte value) {
			addCriterion("is_read >", value, "isRead");
			return (Criteria) this;
		}

		public Criteria andIsReadGreaterThanOrEqualTo(Byte value) {
			addCriterion("is_read >=", value, "isRead");
			return (Criteria) this;
		}

		public Criteria andIsReadLessThan(Byte value) {
			addCriterion("is_read <", value, "isRead");
			return (Criteria) this;
		}

		public Criteria andIsReadLessThanOrEqualTo(Byte value) {
			addCriterion("is_read <=", value, "isRead");
			return (Criteria) this;
		}

		public Criteria andIsReadIn(List<Byte> values) {
			addCriterion("is_read in", values, "isRead");
			return (Criteria) this;
		}

		public Criteria andIsReadNotIn(List<Byte> values) {
			addCriterion("is_read not in", values, "isRead");
			return (Criteria) this;
		}

		public Criteria andIsReadBetween(Byte value1, Byte value2) {
			addCriterion("is_read between", value1, value2, "isRead");
			return (Criteria) this;
		}

		public Criteria andIsReadNotBetween(Byte value1, Byte value2) {
			addCriterion("is_read not between", value1, value2, "isRead");
			return (Criteria) this;
		}

		public Criteria andReadTimeIsNull() {
			addCriterion("read_time is null");
			return (Criteria) this;
		}

		public Criteria andReadTimeIsNotNull() {
			addCriterion("read_time is not null");
			return (Criteria) this;
		}

		public Criteria andReadTimeEqualTo(Long value) {
			addCriterion("read_time =", value, "readTime");
			return (Criteria) this;
		}

		public Criteria andReadTimeNotEqualTo(Long value) {
			addCriterion("read_time <>", value, "readTime");
			return (Criteria) this;
		}

		public Criteria andReadTimeGreaterThan(Long value) {
			addCriterion("read_time >", value, "readTime");
			return (Criteria) this;
		}

		public Criteria andReadTimeGreaterThanOrEqualTo(Long value) {
			addCriterion("read_time >=", value, "readTime");
			return (Criteria) this;
		}

		public Criteria andReadTimeLessThan(Long value) {
			addCriterion("read_time <", value, "readTime");
			return (Criteria) this;
		}

		public Criteria andReadTimeLessThanOrEqualTo(Long value) {
			addCriterion("read_time <=", value, "readTime");
			return (Criteria) this;
		}

		public Criteria andReadTimeIn(List<Long> values) {
			addCriterion("read_time in", values, "readTime");
			return (Criteria) this;
		}

		public Criteria andReadTimeNotIn(List<Long> values) {
			addCriterion("read_time not in", values, "readTime");
			return (Criteria) this;
		}

		public Criteria andReadTimeBetween(Long value1, Long value2) {
			addCriterion("read_time between", value1, value2, "readTime");
			return (Criteria) this;
		}

		public Criteria andReadTimeNotBetween(Long value1, Long value2) {
			addCriterion("read_time not between", value1, value2, "readTime");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table app_read
	 * @mbggenerated  Thu Jun 15 15:30:48 CST 2017
	 */
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

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table app_read
     *
     * @mbggenerated do_not_delete_during_merge Tue Jun 13 10:16:38 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}