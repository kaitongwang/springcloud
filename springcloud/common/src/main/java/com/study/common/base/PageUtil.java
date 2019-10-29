package com.study.common.base;

import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述: 获取分页返回实体
 *
 * @Author;wangkaitong
 * @Date;2019/7/22
 * @Version;1.0
 * @Senice;1.0
 */
public class PageUtil {
    /**
     * 分页
     * @param page  第几页 从 1开始
     * @param list
     * @return
     */
    public static Map<String, Object> startPage(int page, List list) {
        Map<String, Object> resultMap = new HashMap<>();
        PageInfo<Object> pageInfo = new PageInfo<>(list);
        resultMap.put("rows", pageInfo.getList());
        resultMap.put("records", pageInfo.getTotal());
        resultMap.put("total", pageInfo.getPages());
        resultMap.put("page", page);
        return resultMap;

    }

    public static BasePage getPageList(int page,List list){
        BasePage basePage = new BasePage();
        PageInfo<Object> pageInfo = new PageInfo<>(list);
        basePage.setTotalCount(pageInfo.getTotal());
        basePage.setData(pageInfo.getList());
        basePage.setPageNo(page);
        basePage.setPageSize(pageInfo.getPageSize());
        basePage.setPages(pageInfo.getPages());
        return basePage;
    }

    public static BasePage  getBasePage(PageInfo page) {
        BasePage basePage = new BasePage();
        basePage.setPageSize((int) page.getTotal());
        basePage.setPageNo(page.getPageNum());
        basePage.setPageSize(page.getPageSize());
        basePage.setPages(page.getPages());
        basePage.setData(page.getList());
        return basePage;
    }


    /**
     * 根据springframework.data.domain.Page对象 转化为BasePage对象
     * @param search  springframework.data.domain.Page对象
     * @return BasePage对象
     */
    public static BasePage getPageByPage( Page search){

        BasePage basePage = new BasePage();
        basePage.setTotalCount(search.getTotalElements());
        basePage.setData(search.getContent());
        basePage.setPageNo(search.getPageable().getPageNumber()+1);
        basePage.setPageSize(search.getPageable().getPageSize());
        basePage.setPages(search.getTotalPages());
        return basePage;

    }

    /**
     *  描述：  Java后台分页 传入list 请求也，分页参数，返回basePage
     * @param page  第几页
     * @param rows  每页数量
     * @param list   整个list列表
     * @param <T>  实体对象
     * @return  返回你要查询页的list
     */
    public static<T>  BasePage<T>  getPageList( int page, int  rows,List<T> list){
        if(list==null||list.size()==0){
            return null;
        }
        BasePage<T> pageReq = new BasePage<T>();
        pageReq.setPageNo(page);
        pageReq.setPageSize(rows);
        // 如果请求页或者请求记录数为空，则直接返回无记录
        if(page<1||rows<1){
            return pageReq;
        }
        //获取总记录数
        pageReq.setTotalCount(Long.valueOf(list.size()));

        // 获取总页数，如果刚好整除，则直接去商，如果不能整除，则商取余数+1
        if(list.size()%rows!=0){
            pageReq.setPages(list.size()/rows+1);
        }else {
            pageReq.setPages(list.size()/rows);
        }
        // 请求页大于总页数
        if(page>pageReq.getPages()){
            return pageReq;
        }
        // 如果请求页是最后一页
        if(page ==pageReq.getPages()){
            // 如果最后一页只有一条记录
            if((page-1)*rows==list.size()-1){
                List<T> list1 = new ArrayList<T>();
                list1.add(list.get(list.size()-1));
                pageReq.setData(list1);
                return pageReq;
            }else {
                //如果最后一页不止一条记录
                pageReq.setData(list.subList((page-1)*rows,list.size()));
                return  pageReq;
            }
        }else{
            // 请求页不是最后一页
            pageReq.setData(list.subList((page-1)*rows,page*rows));
            return  pageReq;
        }


    }


}