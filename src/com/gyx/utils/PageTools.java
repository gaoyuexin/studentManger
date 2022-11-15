package com.gyx.utils;

public class PageTools {
    private int totalCount;
    private int currentPage;
    private int pageCount;
    private int lastPage;
    private int nextPage;
    private int startIndex;
    private int pageSize;

    public PageTools() {
    }
    public PageTools(int totalCount, String currentPage, int pageSize) {
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        initalCurrentPage(currentPage);
        initalpageCount();
        initallastPage();
        initalnextPage();
        initalstartIndex();

    }

    private void initalpageCount() {
        pageCount = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
    }

    private void initalstartIndex() {
        startIndex = (currentPage - 1) * pageSize;
    }

    private void initalnextPage() {
        if (currentPage == pageCount) {
            nextPage = pageCount;
        } else {
            nextPage = currentPage + 1;
        }
    }

    private void initallastPage() {
        if (currentPage == 1) {
            lastPage = 1;
        } else {
            lastPage = currentPage - 1;
        }
    }

    private void initalCurrentPage(String currentPage) {
        if (currentPage != null) {
            this.currentPage = Integer.valueOf(currentPage);
        } else {
            this.currentPage = 1;
        }

    }
    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getLastPage() {
        return lastPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "PageTools{" +
                "totalCount=" + totalCount +
                ", currentPage=" + currentPage +
                ", lastPage=" + lastPage +
                ", pageCount=" + pageCount +
                ", nextPage=" + nextPage +
                ", startIndex=" + startIndex +
                ", pageSize=" + pageSize +
                '}';
    }
}
