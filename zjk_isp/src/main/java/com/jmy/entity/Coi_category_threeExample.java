package com.jmy.entity;

import java.util.ArrayList;
import java.util.List;

public class Coi_category_threeExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table isp_coi_category_three
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table isp_coi_category_three
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table isp_coi_category_three
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table isp_coi_category_three
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	public Coi_category_threeExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table isp_coi_category_three
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table isp_coi_category_three
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table isp_coi_category_three
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table isp_coi_category_three
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table isp_coi_category_three
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table isp_coi_category_three
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table isp_coi_category_three
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table isp_coi_category_three
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table isp_coi_category_three
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table isp_coi_category_three
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table isp_coi_category_three
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
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

		public Criteria andOldCodeIsNull() {
			addCriterion("old_code is null");
			return (Criteria) this;
		}

		public Criteria andOldCodeIsNotNull() {
			addCriterion("old_code is not null");
			return (Criteria) this;
		}

		public Criteria andOldCodeEqualTo(String value) {
			addCriterion("old_code =", value, "oldCode");
			return (Criteria) this;
		}

		public Criteria andOldCodeNotEqualTo(String value) {
			addCriterion("old_code <>", value, "oldCode");
			return (Criteria) this;
		}

		public Criteria andOldCodeGreaterThan(String value) {
			addCriterion("old_code >", value, "oldCode");
			return (Criteria) this;
		}

		public Criteria andOldCodeGreaterThanOrEqualTo(String value) {
			addCriterion("old_code >=", value, "oldCode");
			return (Criteria) this;
		}

		public Criteria andOldCodeLessThan(String value) {
			addCriterion("old_code <", value, "oldCode");
			return (Criteria) this;
		}

		public Criteria andOldCodeLessThanOrEqualTo(String value) {
			addCriterion("old_code <=", value, "oldCode");
			return (Criteria) this;
		}

		public Criteria andOldCodeLike(String value) {
			addCriterion("old_code like", value, "oldCode");
			return (Criteria) this;
		}

		public Criteria andOldCodeNotLike(String value) {
			addCriterion("old_code not like", value, "oldCode");
			return (Criteria) this;
		}

		public Criteria andOldCodeIn(List<String> values) {
			addCriterion("old_code in", values, "oldCode");
			return (Criteria) this;
		}

		public Criteria andOldCodeNotIn(List<String> values) {
			addCriterion("old_code not in", values, "oldCode");
			return (Criteria) this;
		}

		public Criteria andOldCodeBetween(String value1, String value2) {
			addCriterion("old_code between", value1, value2, "oldCode");
			return (Criteria) this;
		}

		public Criteria andOldCodeNotBetween(String value1, String value2) {
			addCriterion("old_code not between", value1, value2, "oldCode");
			return (Criteria) this;
		}

		public Criteria andCodeIsNull() {
			addCriterion("code is null");
			return (Criteria) this;
		}

		public Criteria andCodeIsNotNull() {
			addCriterion("code is not null");
			return (Criteria) this;
		}

		public Criteria andCodeEqualTo(String value) {
			addCriterion("code =", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotEqualTo(String value) {
			addCriterion("code <>", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeGreaterThan(String value) {
			addCriterion("code >", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeGreaterThanOrEqualTo(String value) {
			addCriterion("code >=", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeLessThan(String value) {
			addCriterion("code <", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeLessThanOrEqualTo(String value) {
			addCriterion("code <=", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeLike(String value) {
			addCriterion("code like", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotLike(String value) {
			addCriterion("code not like", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeIn(List<String> values) {
			addCriterion("code in", values, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotIn(List<String> values) {
			addCriterion("code not in", values, "code");
			return (Criteria) this;
		}

		public Criteria andCodeBetween(String value1, String value2) {
			addCriterion("code between", value1, value2, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotBetween(String value1, String value2) {
			addCriterion("code not between", value1, value2, "code");
			return (Criteria) this;
		}

		public Criteria andFullCodeIsNull() {
			addCriterion("full_code is null");
			return (Criteria) this;
		}

		public Criteria andFullCodeIsNotNull() {
			addCriterion("full_code is not null");
			return (Criteria) this;
		}

		public Criteria andFullCodeEqualTo(String value) {
			addCriterion("full_code =", value, "fullCode");
			return (Criteria) this;
		}

		public Criteria andFullCodeNotEqualTo(String value) {
			addCriterion("full_code <>", value, "fullCode");
			return (Criteria) this;
		}

		public Criteria andFullCodeGreaterThan(String value) {
			addCriterion("full_code >", value, "fullCode");
			return (Criteria) this;
		}

		public Criteria andFullCodeGreaterThanOrEqualTo(String value) {
			addCriterion("full_code >=", value, "fullCode");
			return (Criteria) this;
		}

		public Criteria andFullCodeLessThan(String value) {
			addCriterion("full_code <", value, "fullCode");
			return (Criteria) this;
		}

		public Criteria andFullCodeLessThanOrEqualTo(String value) {
			addCriterion("full_code <=", value, "fullCode");
			return (Criteria) this;
		}

		public Criteria andFullCodeLike(String value) {
			addCriterion("full_code like", value, "fullCode");
			return (Criteria) this;
		}

		public Criteria andFullCodeNotLike(String value) {
			addCriterion("full_code not like", value, "fullCode");
			return (Criteria) this;
		}

		public Criteria andFullCodeIn(List<String> values) {
			addCriterion("full_code in", values, "fullCode");
			return (Criteria) this;
		}

		public Criteria andFullCodeNotIn(List<String> values) {
			addCriterion("full_code not in", values, "fullCode");
			return (Criteria) this;
		}

		public Criteria andFullCodeBetween(String value1, String value2) {
			addCriterion("full_code between", value1, value2, "fullCode");
			return (Criteria) this;
		}

		public Criteria andFullCodeNotBetween(String value1, String value2) {
			addCriterion("full_code not between", value1, value2, "fullCode");
			return (Criteria) this;
		}

		public Criteria andNameIsNull() {
			addCriterion("name is null");
			return (Criteria) this;
		}

		public Criteria andNameIsNotNull() {
			addCriterion("name is not null");
			return (Criteria) this;
		}

		public Criteria andNameEqualTo(String value) {
			addCriterion("name =", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotEqualTo(String value) {
			addCriterion("name <>", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThan(String value) {
			addCriterion("name >", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThanOrEqualTo(String value) {
			addCriterion("name >=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThan(String value) {
			addCriterion("name <", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThanOrEqualTo(String value) {
			addCriterion("name <=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLike(String value) {
			addCriterion("name like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotLike(String value) {
			addCriterion("name not like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameIn(List<String> values) {
			addCriterion("name in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotIn(List<String> values) {
			addCriterion("name not in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameBetween(String value1, String value2) {
			addCriterion("name between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotBetween(String value1, String value2) {
			addCriterion("name not between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andPidIsNull() {
			addCriterion("pid is null");
			return (Criteria) this;
		}

		public Criteria andPidIsNotNull() {
			addCriterion("pid is not null");
			return (Criteria) this;
		}

		public Criteria andPidEqualTo(Integer value) {
			addCriterion("pid =", value, "pid");
			return (Criteria) this;
		}

		public Criteria andPidNotEqualTo(Integer value) {
			addCriterion("pid <>", value, "pid");
			return (Criteria) this;
		}

		public Criteria andPidGreaterThan(Integer value) {
			addCriterion("pid >", value, "pid");
			return (Criteria) this;
		}

		public Criteria andPidGreaterThanOrEqualTo(Integer value) {
			addCriterion("pid >=", value, "pid");
			return (Criteria) this;
		}

		public Criteria andPidLessThan(Integer value) {
			addCriterion("pid <", value, "pid");
			return (Criteria) this;
		}

		public Criteria andPidLessThanOrEqualTo(Integer value) {
			addCriterion("pid <=", value, "pid");
			return (Criteria) this;
		}

		public Criteria andPidIn(List<Integer> values) {
			addCriterion("pid in", values, "pid");
			return (Criteria) this;
		}

		public Criteria andPidNotIn(List<Integer> values) {
			addCriterion("pid not in", values, "pid");
			return (Criteria) this;
		}

		public Criteria andPidBetween(Integer value1, Integer value2) {
			addCriterion("pid between", value1, value2, "pid");
			return (Criteria) this;
		}

		public Criteria andPidNotBetween(Integer value1, Integer value2) {
			addCriterion("pid not between", value1, value2, "pid");
			return (Criteria) this;
		}

		public Criteria andLevelIsNull() {
			addCriterion("level is null");
			return (Criteria) this;
		}

		public Criteria andLevelIsNotNull() {
			addCriterion("level is not null");
			return (Criteria) this;
		}

		public Criteria andLevelEqualTo(Integer value) {
			addCriterion("level =", value, "level");
			return (Criteria) this;
		}

		public Criteria andLevelNotEqualTo(Integer value) {
			addCriterion("level <>", value, "level");
			return (Criteria) this;
		}

		public Criteria andLevelGreaterThan(Integer value) {
			addCriterion("level >", value, "level");
			return (Criteria) this;
		}

		public Criteria andLevelGreaterThanOrEqualTo(Integer value) {
			addCriterion("level >=", value, "level");
			return (Criteria) this;
		}

		public Criteria andLevelLessThan(Integer value) {
			addCriterion("level <", value, "level");
			return (Criteria) this;
		}

		public Criteria andLevelLessThanOrEqualTo(Integer value) {
			addCriterion("level <=", value, "level");
			return (Criteria) this;
		}

		public Criteria andLevelIn(List<Integer> values) {
			addCriterion("level in", values, "level");
			return (Criteria) this;
		}

		public Criteria andLevelNotIn(List<Integer> values) {
			addCriterion("level not in", values, "level");
			return (Criteria) this;
		}

		public Criteria andLevelBetween(Integer value1, Integer value2) {
			addCriterion("level between", value1, value2, "level");
			return (Criteria) this;
		}

		public Criteria andLevelNotBetween(Integer value1, Integer value2) {
			addCriterion("level not between", value1, value2, "level");
			return (Criteria) this;
		}

		public Criteria andStatusIsNull() {
			addCriterion("status is null");
			return (Criteria) this;
		}

		public Criteria andStatusIsNotNull() {
			addCriterion("status is not null");
			return (Criteria) this;
		}

		public Criteria andStatusEqualTo(Byte value) {
			addCriterion("status =", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotEqualTo(Byte value) {
			addCriterion("status <>", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThan(Byte value) {
			addCriterion("status >", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("status >=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThan(Byte value) {
			addCriterion("status <", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThanOrEqualTo(Byte value) {
			addCriterion("status <=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusIn(List<Byte> values) {
			addCriterion("status in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotIn(List<Byte> values) {
			addCriterion("status not in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusBetween(Byte value1, Byte value2) {
			addCriterion("status between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("status not between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andIsdelIsNull() {
			addCriterion("isdel is null");
			return (Criteria) this;
		}

		public Criteria andIsdelIsNotNull() {
			addCriterion("isdel is not null");
			return (Criteria) this;
		}

		public Criteria andIsdelEqualTo(Byte value) {
			addCriterion("isdel =", value, "isdel");
			return (Criteria) this;
		}

		public Criteria andIsdelNotEqualTo(Byte value) {
			addCriterion("isdel <>", value, "isdel");
			return (Criteria) this;
		}

		public Criteria andIsdelGreaterThan(Byte value) {
			addCriterion("isdel >", value, "isdel");
			return (Criteria) this;
		}

		public Criteria andIsdelGreaterThanOrEqualTo(Byte value) {
			addCriterion("isdel >=", value, "isdel");
			return (Criteria) this;
		}

		public Criteria andIsdelLessThan(Byte value) {
			addCriterion("isdel <", value, "isdel");
			return (Criteria) this;
		}

		public Criteria andIsdelLessThanOrEqualTo(Byte value) {
			addCriterion("isdel <=", value, "isdel");
			return (Criteria) this;
		}

		public Criteria andIsdelIn(List<Byte> values) {
			addCriterion("isdel in", values, "isdel");
			return (Criteria) this;
		}

		public Criteria andIsdelNotIn(List<Byte> values) {
			addCriterion("isdel not in", values, "isdel");
			return (Criteria) this;
		}

		public Criteria andIsdelBetween(Byte value1, Byte value2) {
			addCriterion("isdel between", value1, value2, "isdel");
			return (Criteria) this;
		}

		public Criteria andIsdelNotBetween(Byte value1, Byte value2) {
			addCriterion("isdel not between", value1, value2, "isdel");
			return (Criteria) this;
		}

		public Criteria andPcodeIsNull() {
			addCriterion("pcode is null");
			return (Criteria) this;
		}

		public Criteria andPcodeIsNotNull() {
			addCriterion("pcode is not null");
			return (Criteria) this;
		}

		public Criteria andPcodeEqualTo(String value) {
			addCriterion("pcode =", value, "pcode");
			return (Criteria) this;
		}

		public Criteria andPcodeNotEqualTo(String value) {
			addCriterion("pcode <>", value, "pcode");
			return (Criteria) this;
		}

		public Criteria andPcodeGreaterThan(String value) {
			addCriterion("pcode >", value, "pcode");
			return (Criteria) this;
		}

		public Criteria andPcodeGreaterThanOrEqualTo(String value) {
			addCriterion("pcode >=", value, "pcode");
			return (Criteria) this;
		}

		public Criteria andPcodeLessThan(String value) {
			addCriterion("pcode <", value, "pcode");
			return (Criteria) this;
		}

		public Criteria andPcodeLessThanOrEqualTo(String value) {
			addCriterion("pcode <=", value, "pcode");
			return (Criteria) this;
		}

		public Criteria andPcodeLike(String value) {
			addCriterion("pcode like", value, "pcode");
			return (Criteria) this;
		}

		public Criteria andPcodeNotLike(String value) {
			addCriterion("pcode not like", value, "pcode");
			return (Criteria) this;
		}

		public Criteria andPcodeIn(List<String> values) {
			addCriterion("pcode in", values, "pcode");
			return (Criteria) this;
		}

		public Criteria andPcodeNotIn(List<String> values) {
			addCriterion("pcode not in", values, "pcode");
			return (Criteria) this;
		}

		public Criteria andPcodeBetween(String value1, String value2) {
			addCriterion("pcode between", value1, value2, "pcode");
			return (Criteria) this;
		}

		public Criteria andPcodeNotBetween(String value1, String value2) {
			addCriterion("pcode not between", value1, value2, "pcode");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table isp_coi_category_three
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
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
     * This class corresponds to the database table isp_coi_category_three
     *
     * @mbggenerated do_not_delete_during_merge Mon Mar 20 20:47:20 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}