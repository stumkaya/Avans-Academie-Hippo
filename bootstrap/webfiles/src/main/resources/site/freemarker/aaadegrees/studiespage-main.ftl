<#include "../include/imports.ftl">

<@hst.include ref="quicknav"/>

<div class="row">
<@hst.include ref="hero"/>
</div>

<div class="container">
  <div class="row">
    <section class="col-xs-12 col-sm-8">
    <@hst.include ref="content"/>
    </section>
    <aside class="col-xs-12 col-sm-4">
      <@hst.include ref="top-right"/>
      <@hst.include ref="right-standardized"/>
      <@hst.include ref="right"/>
    </aside>
  </div>
</div>

<@hst.include ref="slider"/>

<div class="container">
  <div class="row">
    <section class="col-xs-12">
    <@hst.include ref="bottom-content"/>
    </section>
  </div>
</div>

