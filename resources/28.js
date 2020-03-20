const concat = Array.prototype.concat

function fltn (c) {
  if (typeof c === 'object') {
    return concat.apply([], c.map(fltn))
  } else {
    return [c]
  }
}

const fltn2 = c => c.reduce((acc, n) => {
  if (typeof n === 'object') {
    return acc.concat(fltn2(n))
  } else {
    return acc.concat([n])
  }
}, [])

console.log(fltn([[1, 2], 3, [4, [5, 6]]]))
console.log(fltn2([[1, 2], 3, [4, [5, 6]]]))
