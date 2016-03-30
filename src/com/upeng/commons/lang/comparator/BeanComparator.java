package com.upeng.commons.lang.comparator;

import java.util.Comparator;

import com.upeng.commons.beans.BeanUtils;
import com.upeng.commons.lang.ArrayUtils;
import com.upeng.commons.lang.StringUtils;

public class BeanComparator implements Comparator {
	
	private String comparaFields;
	private boolean asc = true;
	
	public int compare(Object o1, Object o2) {
		if(asc){
			return compareASC(o1, o2);
		}else{
			return 0 - compareASC(o1, o2);
		}
	}
	
	public int compareASC(Object o1, Object o2) {
		if(o1 == null && o2 == null){
			return 0;
		}else if(o1 == null && o2 != null){
			return -1;
		}else if(o2 == null && o1 != null){
			return 1;
		}
		if(StringUtils.isNotBlank(comparaFields)){
			String[] strs = ArrayUtils.toStringArray(comparaFields);
			for(String str : strs){
				Object value1 = null;
				value1 = BeanUtils.getValue(o1, str);
				Object value2 = null;
				value2 = BeanUtils.getValue(o2, str);
				if(value1 == null && value2 == null){
					return 0;
				}else if(value1 == null && value2 != null){
					return -1;
				}else if(value2 == null && value1 != null){
					return 1;
				}else{
					int result = value1.hashCode() - value2.hashCode();
					if(result != 0){
						return result;
					}
				}
			}
		}
		return o1.hashCode() - o2.hashCode();
	}


	public boolean isAsc() {
		return asc;
	}

	public void setAsc(boolean asc) {
		this.asc = asc;
	}

	public String getComparaFields() {
		return comparaFields;
	}

	public void setComparaFields(String comparaFields) {
		this.comparaFields = comparaFields;
	}

}
