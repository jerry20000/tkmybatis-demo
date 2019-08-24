package cn.sisyphe.demo.core.base;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * Description:
 * Date: 2017/04/30
 *
 * @author penghao
 * @version 1.0
 */
public class Pagination implements Serializable {

    private static final long serialVersionUID = 1L;

    private final int offset;
    private final int limit;

    public Pagination(int offset, int limit) {
        if (limit < 0) {
            throw new IllegalArgumentException("limit cannot be lesser than 0 for pagination.");
        }

        this.offset = offset;
        this.limit = limit;
    }

    public int getPageNumber() {
        if (offset < limit || limit == 0) {
            return 1;
        }
        return (offset / limit) + 1;
    }

    public int getOffset() {
        return offset;
    }

    public int getLimit() {
        return limit;
    }

    public Pagination getNext() {
        return new Pagination(offset + limit, limit);
    }

    public Pagination getPrevious() {
        int prevOffset = limit >= offset ? 0 : offset - limit;
        return new Pagination(prevOffset, limit);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
