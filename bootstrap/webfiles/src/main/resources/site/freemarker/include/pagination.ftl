<#-- @ftlvariable name="pageable" type="org.onehippo.cms7.essentials.components.paging.Pageable" -->
<#include "../include/imports.ftl">
<#if pageable??>
    <@hst.setBundle basename="essentials.pagination"/>
<div class="search-page-buttons">
    <#if pageable.totalPages gt 1>
        <#list pageable.pageNumbersArray as pageNr>
            <@hst.renderURL var="pageUrl">
                <@hst.param name="page" value="${pageNr}"/>
                <@hst.param name="pageSize" value="${pageable.pageSize}"/>
            </@hst.renderURL>


            <#if pageable.previous>
                <#assign prevbtn="btn-primary"/>
            <#else>
                <#assign prevbtn="btn-inactive"/>
            </#if>

            <#if pageNr_index==0>
                <@hst.renderURL var="pageUrlPrevious">
                    <@hst.param name="page" value="${pageable.previousPage}"/>
                    <@hst.param name="pageSize" value="${pageable.pageSize}"/>
                </@hst.renderURL>
              <a href="${pageUrlPrevious}" class="btn ${prevbtn} <#if !pageable.previous>disabled</#if>"><@fmt.message key="page.previous" var="prev"/>${prev?html}
               <#if pageable.currentPage == pageable.endPage-1>
                    ${pageable.total-(pageable.pageSize*pageable.currentPage)}
                <#elseif pageable.previous>
                    ${pageable.pageSize}
                </#if>
              </a>
            </#if>


            <#if pageable.next>
                <#assign nextbtn="btn-primary"/>
            <#else>
                <#assign nextbtn="btn-inactive"/>
            </#if>

            <#if !pageNr_has_next>
                <@hst.renderURL var="pageUrlNext">
                    <@hst.param name="page" value="${pageable.nextPage}"/>
                    <@hst.param name="pageSize" value="${pageable.pageSize}"/>
                </@hst.renderURL>
              <a href="${pageUrlNext}" class="btn ${nextbtn} <#if !pageable.next>disabled</#if>">
                  <@fmt.message key="page.next" var="next"/>${next?html}
                <#if pageable.currentPage == pageable.endPage-1>
                    ${pageable.total-(pageable.pageSize*pageable.currentPage)}
                <#elseif pageable.next>
                    ${pageable.pageSize}
                </#if>
              </a>
            </#if>

        </#list>


    </#if>
</div>
</#if>