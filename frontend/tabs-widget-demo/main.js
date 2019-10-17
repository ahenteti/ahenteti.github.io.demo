(function () {
  var tabs = Array.from(document.querySelectorAll('[role="tab"]'));
  var panels = Array.from(document.querySelectorAll('[role="tabpanel"]'));

  for (i = 0; i < tabs.length; i++) {
    tabs[i].addEventListener('click', event => activateTab(event.target));
  }

  function activateTab (tab) {
    deactivateTabs();
    tab.setAttribute('aria-selected', 'true');
    var controls = tab.getAttribute('aria-controls');
    document.getElementById(controls).removeAttribute('hidden');
  }

  function deactivateTabs () {
    for (i = 0; i < tabs.length; i++) {
      tabs[i].setAttribute('aria-selected', 'false');
      panels[i].setAttribute('hidden', 'true');
    }
  }
})();