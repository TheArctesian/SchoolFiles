<script>
	import Select from 'svelte-select';
	
	const items = ['One', 'Two', 'Three'];
	
	const complexItems = [
		{value: 'chocolate', label: 'Chocolate', group: 'Sweet'},
    {value: 'pizza', label: 'Pizza', group: 'Savory'},
    {value: 'cake', label: 'Cake', group: 'Sweet'},
    {value: 'chips', label: 'Chips', group: 'Savory'},
    {value: 'ice-cream', label: 'Ice Cream', group: 'Sweet'}
	];
	
	const groupBy = (item) => item.group;
	const optionIdentifier = 'id';
  const getOptionLabel = (option) => option.name;
  const getSelectionLabel = (option) => option.name;
</script>

<style>
	/* 	CSS variables can be used to control theming.
			https://github.com/rob-balfre/svelte-select/blob/master/docs/theming_variables.md
	*/
	
	.themed {
		--border: 3px solid blue;
		--borderRadius: 10px;
		--placeholderColor: blue;
	}
</style>

<h2>Test</h2>
<Select {items}></Select>

<h2>Food</h2>
<Select items={complexItems}></Select>

<h2>Group</h2>
<Select items={complexItems} {groupBy}></Select>

<h2>Mutli</h2>
<Select items={complexItems} isMulti={true}></Select>


<div class="themed">
	<h2>Theming</h2>
	<Select {items}></Select>	
</div>

