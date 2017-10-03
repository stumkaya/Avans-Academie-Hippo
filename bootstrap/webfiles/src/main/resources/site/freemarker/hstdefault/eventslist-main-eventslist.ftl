<#include "../include/imports.ftl">

<#-- @ftlvariable name="item" type="nl.avans.beans.EventsDocument" -->
<#-- @ftlvariable name="pageable" type="org.onehippo.cms7.essentials.components.paging.Pageable" -->


<div class="header-row">
  <div class="component-header">
    <div class="container">
      <div class="row">
        <div class="col-xs-12">
          <h1>Evenementen</h1>
        </div>
      </div>
    </div>
  </div>
</div>


<#if pageable?? && pageable.items?has_content>

<div class="container">
  <div class="row">

    <div class="col-xs-12 col-sm-8">

        <#list pageable.items as item>
            <@hst.link var="link" hippobean=item />
            <a class="event" href="${link}">
              <@hst.cmseditlink hippobean=item/>
              <div class="event__image" style="background-image: url(<@hst.link hippobean=item.image/>);"></div>
              <div class="event__body">
                <span class="event__date">
                    <@fmt.formatDate value=item.date.time type="date" dateStyle="medium"/>
                </span>
                <#if item.title1??><span class="event__title">${item.title1}</span></#if>
                <#if item.location??><span class="event__location">${item.location}</span></#if>
              </div>
            </a>
        </#list>
        <#if cparam.showPagination>
            <#include "../include/pagination.ftl">
        </#if>

    </div>

  </div>
</div>

<#-- @ftlvariable name="editMode" type="java.lang.Boolean"-->
<#elseif editMode>
<img src="<@hst.link path='/images/essentials/catalog-component-icons/events-list.png'/>"> Click to edit Event List
</#if>

