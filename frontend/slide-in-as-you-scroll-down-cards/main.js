function alreadyVisible (card) {
  let position = card.getBoundingClientRect();
  return position.top < window.innerHeight;
}

function visible (card) {
  let position = card.getBoundingClientRect();
  return position.bottom > 0 && position.top < window.innerHeight;
}

document.querySelectorAll('.card').forEach(card => {
  if (alreadyVisible(card)) {
    card.classList.add('already-visible')
  } else {
    card.classList.add('not-yet-visible')
  }
});

window.addEventListener('scroll', function () {
  document.querySelectorAll('.card').forEach(card => {
    if (visible(card)) {
      card.classList.add('visible-after-scroll')
    }
  });
})