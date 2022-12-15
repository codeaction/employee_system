package com.stedu.utils;


import com.stedu.bean.Page;

/*
 * 分页信息辅助类
 */
public class PageUtil {
	public static Page createPage(int everyPage, int totalCount, int currentPage) {// 创建分页信息对象
		everyPage = getEveryPage(everyPage);
		int totalPage = getTotalPage(everyPage, totalCount);
		currentPage = getCurrentPage(currentPage, totalPage);
		int beginIndex = getBeginIndex(everyPage, currentPage);
		boolean hasPrePage = getHasPrePage(currentPage);
		boolean hasNextPage = getHasNextPage(totalPage, currentPage);
		int[] navigation = getNavigation(totalPage, currentPage);
		return new Page(everyPage, totalCount, totalPage, currentPage, beginIndex, hasPrePage, hasNextPage, navigation);
	}

	public static int getEveryPage(int everyPage) {// 获得每页显示记录数
		return everyPage == 0 ? 10 : everyPage;
	}

	public static int getCurrentPage(int currentPage, int totalPage) { // 获得当前页
		currentPage = currentPage == 0 ? 1 : currentPage;
		currentPage = currentPage < 0 ? totalPage : currentPage;
		currentPage = currentPage > totalPage ? totalPage : currentPage;
		return currentPage;
	}

	public static int getTotalPage(int everyPage, int totalCount) {// 获得总页数
		int totalPage = 0;
		if (totalCount != 0 && totalCount % everyPage == 0) {
			totalPage = totalCount / everyPage;
		} else {
			totalPage = totalCount / everyPage + 1;
		}
		return totalPage;
	}

	public static int getBeginIndex(int everyPage, int currentPage) {// 获得起始位置
		return (currentPage - 1) * everyPage;
	}

	public static boolean getHasPrePage(int currentPage) {// 获得是否有上一页
		return currentPage == 1 ? false : true;
	}

	public static boolean getHasNextPage(int totalPage, int currentPage) { // 获得是否有上一页
		return currentPage == totalPage || totalPage == 0 ? false : true;
	}

	public static int[] getNavigation(int totalPage, int currentPage) {
		int[] navigation = null;

		if(totalPage <= 5) {
			navigation = new int[totalPage];
			for (int i = 0; i < navigation.length; i++) {
				navigation[i] = i + 1;
			}
		} else {
			navigation = new int[5];
			int start = currentPage <= 3 ? 1 : currentPage - 2;
			start = totalPage - start < 5 ? totalPage - 4 : start;
			for(int i = 0; i < 5; i++) {
				navigation[i] = start + i;
			}
		}

		return navigation;
	}
}
