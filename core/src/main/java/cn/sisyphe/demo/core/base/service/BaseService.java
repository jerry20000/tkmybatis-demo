package cn.sisyphe.demo.core.base.service;

import cn.sisyphe.demo.core.base.Pagination;
import com.github.pagehelper.PageInfo;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author ：Jerry
 * @date ：Created in 2019/5/8 17:13
 * @description：${description}
 */
public interface BaseService<E> {
    void save(final E entity);

    void save(final List<E> entities);

    void update(final E entity);

    void remove(final Long id);

    void removeByIds(final String ids);

    E get(final Long id);

    List<E> list();

    List<E> listByIds(final String ids);

    List<E> listByEntity(final E entity);

    List<E> listByExample(final Example example);

    PageInfo<E> listByPage(final Pagination pagination);

    PageInfo<E> listByEntityAndPage(final E entity, final Pagination pagination);

    PageInfo<E> listByExampleAndPage(final Example example, final Pagination pagination);

    int count();

}
