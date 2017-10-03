<#include "../include/imports.ftl">

<#-- @ftlvariable name="query" type="java.lang.String" -->
<#-- @ftlvariable name="pageable" type="org.onehippo.cms7.essentials.components.paging.Pageable" -->

<div class="header-row">
  <div class="component-header">
    <div class="container">
      <div class="row">
        <div class="col-xs-12">
          <h1><#if pageable??>${pageable.total}<#else>0</#if> resultaten voor '${query?html}'</h1>
        </div>
      </div>
    </div>
  </div>
</div>
<#if pageable??>
<div class="container">

  <div class="row">

    <div class="col-xs-12 search-page">

        <#list pageable.items as item>
            <#if item.title??>
                <#assign linkName=item.title/>
            <#else>
                <#assign linkName=item.localizedName/>
            </#if>

          <div class="search-result">
            <div class="row">
                <@hst.cmseditlink hippobean=item/>
                <@hst.link var="link" hippobean=item />

              <a href="${link}" class="col-xs-12 col-md-6">
                <div class="search-result__line"></div>

                <h2>${linkName}</h2>

                <span class="search-result__url">${link}</span>

                <p>${item.getSearchResultText(query)!""}</p>
              </a>
            </div>
          </div>

        </#list>

        <#if cparam.showPagination>
            <#include "../include/pagination.ftl">
        </#if>
    </div>
  </div>
</div>
</#if>